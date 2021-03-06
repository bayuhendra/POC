package com.agit.crm.user.management.application.impl;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.crm.shared.status.StatusCode;
import com.agit.crm.shared.type.AccessType;
import com.agit.crm.shared.type.JenisKelaminType;
import com.agit.crm.shared.type.JobDivision;
import com.agit.crm.shared.type.JobLocation;
import com.agit.crm.shared.type.PendidikanType;
import com.agit.crm.shared.type.ReleaseType;
import com.agit.crm.shared.type.StatusData;
import com.agit.crm.shared.type.TingkatanType;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.user.management.domain.privilege.Privilege;
import com.agit.crm.user.management.domain.privilege.PrivilegeBuilder;
import com.agit.crm.user.management.domain.role.Role;
import com.agit.crm.user.management.domain.role.RoleBuilder;
import com.agit.crm.user.management.domain.role.RolePrivilege;
import com.agit.crm.user.management.domain.role.RolePrivilegeBuilder;
import com.agit.crm.user.management.domain.user.AccessTime;
import com.agit.crm.user.management.domain.user.AccessTimeBuilder;
import com.agit.crm.user.management.domain.user.User;
import com.agit.crm.user.management.domain.user.UserBuilder;
import com.agit.crm.user.management.domain.user.UserLoginInfo;
import com.agit.crm.user.management.domain.user.UserLoginInfoBuilder;
import com.agit.crm.user.management.domain.user.UserRepository;
import com.agit.crm.user.management.domain.user.UserSpecification;
import com.agit.crm.user.management.domain.user.UserSpecificationBuilder;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.user.UserDTOAssembler;
import com.agit.crm.user.management.interfaces.web.facade.dto.assembler.user.UserLoginInfoDTOAssembler;
import com.agit.crm.util.StringUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author bayutridewanto
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDTOAssembler userDTOAssembler;

    @Override
    public void saveOrUpdate(UserDTO userDTO) {
        User user = userRepository.findByID(userDTO.getUserName());
        if (user == null) {
            user = userDTOAssembler.toDomain(userDTO);
        } else {
            /* update specification */
            user.assignNewSpecification(userDTOAssembler.toDomain(userDTO));
        }

        userRepository.saveOrUpdate(user);
    }

    @Override
    public UserDTO findByID(String userName) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByID(userName);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public UserDTO findByRemote(String userName, String remote) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByRemote(userName, remote);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public List<UserDTO> findAllUser() {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findAllUser();
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public List<UserDTO> findByParameter(String fullName, String userName, String roleID, StatusData userStatus) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByParameter(fullName, userName, roleID, userStatus);
        if (users != null) {
            return userDTOAssembler.toDTOs(users);
        }

        return null;
    }

    @Override
    public StatusCode release(String userName, String releaseType, String release) {
        Validate.notNull(userRepository);
        User user;
        if (releaseType.equals(ReleaseType.USERNAME.name())) {
            user = userRepository.findByID(release);
        } else {
            user = userRepository.findByRemote(userName, release);
        }
        if (user != null) {
            user.getUserSpecification().getUserLoginInfo().assignDeleteRemote();
            userRepository.saveOrUpdate(user);
            return StatusCode.CREATED;
        }
        return StatusCode.FOUND;
    }

    @Override
    public StatusCode releaseAll() {
        Validate.notNull(userRepository);
        userRepository.releaseAll();
        return StatusCode.CREATED;
    }

    @Override
    public int count(String roleID) {
        Validate.notNull(userRepository);
        return userRepository.count(roleID);
    }

    @Override
    public StatusCode updatePassword(String userName, String newPassword) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.assignNewPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode updateLockUnlock(String userName, Integer loginAttempt) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.getUserSpecification().getUserLoginInfo().assignNewLoginAttempt(loginAttempt);
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode updateLoginInfo(String userName, UserLoginInfoDTO loginInfo) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.getUserSpecification().assignNewLoginInfo(new UserLoginInfoDTOAssembler().toDomain(loginInfo));
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode delete(String userName) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.assignNewStatus(StatusData.DELETED);
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public Boolean isNotExistUserName(String userName) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        return user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean isNotExistIPAddress(String userName, String ipAddress) {
        Validate.notNull(userRepository);
        User userRemote = userRepository.findByRemote(userName, ipAddress);

        Boolean isResult = Boolean.TRUE;
        if (!StringUtil.hasValue(userRemote)) {
            User user = userRepository.findByID(userName);
            isResult = checkAuthority(user);
        }

        return isResult;
    }

    private Boolean checkAuthority(User user) {
        if (!StringUtil.hasValue(user.getUserSpecification().getUserLoginInfo().getRemoteAddress())
                && !StringUtil.hasValue(user.getUserSpecification().getUserLoginInfo().getSessionID())) {
            return Boolean.TRUE;
        }
        if (StringUtil.hasValue(user.getUserSpecification().getUserLoginInfo().getLoginDate())) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(user.getUserSpecification().getUserLoginInfo().getLoginDate());
            int day1 = cal1.get(Calendar.DAY_OF_MONTH);
            int hour1 = cal1.get(Calendar.HOUR);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(new Date());
            int day2 = cal2.get(Calendar.DAY_OF_MONTH);
            int hour2 = cal2.get(Calendar.HOUR);

            if (day1 != day2) {
                return Boolean.TRUE;
            } else {
                int diffDate = hour2 - hour1;
                if (diffDate != 0) {
                    return Boolean.TRUE;
                }
            }
        } else {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserDTOAssembler(UserDTOAssembler userDTOAssembler) {
        this.userDTOAssembler = userDTOAssembler;
    }

    @Override
    public UserDTO findByKtp(String ktp) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByKtp(ktp);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public UserDTO getDummy() {

        AccessTime accessTime = new AccessTimeBuilder()
                .setFridayEnd(new Date())
                .setFridayStart(new Date())
                .setMondayEnd(new Date())
                .setMondayStart(new Date())
                .setSaturdayEnd(new Date())
                .setSaturdayStart(new Date())
                .setSundayEnd(new Date())
                .setSundayStart(new Date())
                .setThursdayEnd(new Date())
                .setThursdayStart(new Date())
                .setTuesdayEnd(new Date())
                .setTuesdayStart(new Date())
                .setWednesdayEnd(new Date())
                .setWednesdayStart(new Date())
                .createAccessTime();

        UserLoginInfo userLoginInfo = new UserLoginInfoBuilder()
                .setCredentialsExpiredDate(new Date())
                .setLastLogin(new Date())
                .setLastLoginFailed(new Date())
                .setLoginAttempt(1)
                .setLoginDate(new Date())
                .setLogoutDate(new Date())
                .setRemoteAddress("remoteAddress")
                .setRemoteHost("remoteHost")
                .setSessionID("sessionID")
                .createUserLoginInfo();

        UserSpecification specification = new UserSpecificationBuilder()
                .setAccessTime(accessTime)
                .setDomisili("blora")
                .setEmail("a@a.com")
                .setEscute(null)
                .setFullName("Atmaji")
                .setImmediateSupervisorUserName(null)
                .setIpk("3")
                .setJenisKelaminType(JenisKelaminType.WANITA)
                .setJobDivision(JobDivision.TI)
                .setJobLocation(JobLocation.JAKARTA)
                .setJurusan("TI")
                .setKetrampilan1("A")
                .setKetrampilan2("b")
                .setKetrampilan3(null)
                .setKetrampilan4(null)
                .setKetrampilan5(null)
                .setKtp("121")
                .setMinat("c")
                .setMobilePhone("1232")
                .setNamaCivitas("qweq")
                .setNoHP(null)
                .setNoKTP(null)
                .setPendidikanType(PendidikanType.STRATA_I)
                .setPrimaryBranchID(null)
                .setStatusApprove(Boolean.FALSE)
                .setTanggalLahir(null)
                .setTingkatanType1(TingkatanType.KOMPETEN)
                .setTingkatanType2(TingkatanType.KOMPETEN)
                .setTingkatanType3(TingkatanType.KOMPETEN)
                .setTingkatanType4(TingkatanType.KOMPETEN)
                .setTingkatanType5(TingkatanType.KOMPETEN)
                .setUploadCV(null)
                .setUserLoginInfo(userLoginInfo)
                .createUserSpecification();

        Privilege privilege = new PrivilegeBuilder()
                .setCreationalBy("a")
                .setCreationalDate(new Date())
                .setIcon("Icon")
                .setMenu(true)
                .setMenuName("MenuName")
                .setParentID("11")
                .setPrivilegeID("11")
                .setPrivilegeName("PrivilegeName")
                .setPrivilegeStatus(StatusData.ACTIVE)
                .setTabName("TabName")
                .setUrl("X")
                .createPrivilege();

        RolePrivilege rolePrivilege = new RolePrivilegeBuilder()
                .setAccessType(AccessType.ALLOW)
                .setPrivilege(privilege)
                .createRolePrivilege();
        List<RolePrivilege> listRolePrevilage = new ArrayList<>();
        listRolePrevilage.add(rolePrivilege);

        Role role = new RoleBuilder()
                .setRoleID("11")
                .setRoleName("NEw")
                .setRolePrivileges(listRolePrevilage)
                .setRoleStatus(StatusData.DELETED)
                .setCreationalBy("creationalBy")
                .setCreationalDate(new Date())
                .setRoleDescription("roleDescription")
                .createRole();

        User user = new UserBuilder()
                .setCreationalBy("A")
                .setCreationalDate(new Date())
                .setNip("11")
                .setPassword("Password123")
                //                .setRole(role)
                .setUserID("11")
                .setUserName("KK")
                .setUserSpecification(specification)
                .setUserStatus(StatusData.ACTIVE)
                .createUser();
        return userDTOAssembler.toDTO(user);
    }

    @Override
    public UserDTO findByUserID(String userID) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByUserID(userID);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public List<UserDTO> findByParamsMap(Map map) {
        Validate.notNull(userRepository);
        List<User> listMahasiswa = userRepository.findByParamsMap(map);
        if (listMahasiswa != null) {
            return (List<UserDTO>) userDTOAssembler.toDTOs(listMahasiswa);
        }
        return null;
    }

    @Override
    public List<UserDTO> findByRoleID(String roleID) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByRoleID(roleID);
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public List<UserDTO> findAllMahasiswa(long roleid) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findAllByMahasiswa(roleid);
        if (users != null) {
            return userDTOAssembler.toDTOs(users);
        }
        return null;
    }

    @Override
    public List<UserDTO> findByUsername(String userName) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByUsername(userName);
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public UserDTO findByEmail(String email) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByEmail(email);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

}
