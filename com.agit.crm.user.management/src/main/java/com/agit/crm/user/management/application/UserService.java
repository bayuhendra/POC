package com.agit.crm.user.management.application;

import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.dto.usermanagement.UserLoginInfoDTO;
import com.agit.crm.shared.status.StatusCode;
import com.agit.crm.shared.type.StatusData;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public interface UserService {

    void saveOrUpdate(UserDTO user);

    UserDTO findByID(String userName);

    UserDTO findByKtp(String ktp);

    UserDTO findByEmail(String email);

    UserDTO findByRemote(String userName, String remote);

    List<UserDTO> findAllUser();

    List<UserDTO> findByParameter(String fullName, String userName, String roleID, StatusData userStatus);

    StatusCode release(String userName, String releaseType, String release);

    StatusCode releaseAll();

    int count(String roleID);

    StatusCode updatePassword(String userName, String newPassword);

    StatusCode updateLockUnlock(String userName, Integer loginAttempt);

    StatusCode updateLoginInfo(String userName, UserLoginInfoDTO loginInfo);

    StatusCode delete(String userName);

    Boolean isNotExistUserName(String userName);

    Boolean isNotExistIPAddress(String userName, String ipAddress);

    UserDTO findByUserID(String userID);

    UserDTO getDummy();

    List<UserDTO> findAllMahasiswa(long roleid);

    List<UserDTO> findByRoleID(String roleID);

    List<UserDTO> findByParamsMap(Map map);

    List<UserDTO> findByUsername(String userName);
}
