package com.agit.crm.main.viewmodel.customer.touchpoint;

import com.agit.crm.common.application.TouchpointService;
import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTO;
import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTOBuilder;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.util.CommonUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TouchpointVM {

    @WireVariable
    TouchpointService touchpointService;

    @WireVariable
    UserService userService;

    private TouchpointDTO touchpointDTO = new TouchpointDTO();
    private List<TouchpointDTO> touchpointDTOs = new ArrayList<>();
    private String namaTouchpoint;
    private String deskripsi;
    private String url;

    private UserDTO user;

    private PageNavigation previous;
    private String touchpointID;

    @Init
    public void init(
            @ExecutionArgParam("touchpointDTO") TouchpointDTO touchpoint,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(touchpoint, previous);

    }

    private void initData() {
        touchpointDTOs = touchpointService.findAll();
        user = userService.findByID(SecurityUtil.getUserName());
    }

    private void checkValidity(TouchpointDTO touchpoint, PageNavigation previous) {
        if (touchpoint == null) {
            ListModelList<TouchpointDTO> parameterList = new ListModelList<>(touchpointService.findAll());
            String touchpointID = "";
            if (parameterList.isEmpty()) {
                touchpointID = "T001";
            } else {
                touchpointID = getLatestObjectID(parameterList, "touchpointID");
            }
            touchpointDTO = new TouchpointDTOBuilder()
                    .setTouchpointID(touchpointID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createTouchpointDTO();
        } else {
            this.touchpointDTO = touchpoint;
            touchpointID = touchpointDTO.getTouchpointID();
            namaTouchpoint = touchpointDTO.getTouchpoint();
            deskripsi = touchpointDTO.getDeskripsi();
            url = touchpointDTO.getUrl();
            this.previous = previous;
        }
    }

    @GlobalCommand
    @NotifyChange("touchpointDTOs")
    public void refreshDataTouchpoint() {
        touchpointDTOs = touchpointService.findAll();
    }

    @Command("buttonTambahTouchpoint")
    @NotifyChange("touchpointDTO")
    public void buttonTambahTouchpoint(@BindingParam("object") TouchpointDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("touchpointDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-touchpoint/tambah_touchpoint.zul", window, params);
    }

    @Command("ubahTouchpoint")
    @NotifyChange("touchpointDTO")
    public void ubahTouchpoint(@BindingParam("object") TouchpointDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("touchpointDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-touchpoint/tambah_touchpoint.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"touchpointDTO", "touchpointDTOs"})
    public void buttonKembali(@BindingParam("object") TouchpointDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveTouchpoint")
    @NotifyChange({"touchpointDTO", "touchpointDTOs"})
    public void buttonSaveTouchpoint(@BindingParam("object") TouchpointDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        touchpointDTO.setTouchpoint(namaTouchpoint);
        touchpointDTO.setDeskripsi(deskripsi);
        touchpointDTO.setUrl(url);
        touchpointService.saveOrUpdate(touchpointDTO);
        showInformationMessagebox("Data Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataTouchpoint", null);
        window.detach();
    }

    @Command("deleteTouchpoint")
    @NotifyChange("touchpointDTO")
    public void deleteTouchpoint(@BindingParam("object") TouchpointDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        touchpointDTO = (TouchpointDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus data ini?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            touchpointService.deleteData(touchpointDTO);
                            showInformationMessagebox("Data Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshDataTouchpoint", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    protected String getLatestObjectID(ListModelList list, String attribute) {
        int count = 0;
        int pointer = 0;
        int max = 0;
        String s = "";
        for (Object obj : list) {
            Map<String, Object> map = CommonUtil.convertObject2Map(obj);
            String att = attribute;
            String[] arr = new String[attribute.length()];
            String key = "";

            if (att.contains(".")) {
                arr = att.split("\\.");
                int f = 1;
                for (Object x : arr) {
                    if (f != arr.length) {
                        map = CommonUtil.convertObject2Map(map.get(x.toString()));
                    } else {
                        key = x.toString();
                    }
                    f += 1;
                }
            } else {
                key = att;
            }

            att = map.get(key).toString();

            String temp = "";
            int countTemp = 0;
            for (int i = att.length(); i > 0; i--) {
                if (Character.isLetter(att.charAt(i - 1))) {
                    pointer = i;
                    s = att.substring(0, pointer);
                    break;
                }
                countTemp += 1;
                temp = att.charAt(i - 1) + temp;
            }
            if (Integer.parseInt(temp) > max) {
                max = Integer.parseInt(temp);
            }
            count = countTemp;
        }

        return s + String.format("%0" + count + "d", max + 1);
    }

    public TouchpointDTO getTouchpointDTO() {
        return touchpointDTO;
    }

    public void setTouchpointDTO(TouchpointDTO touchpointDTO) {
        this.touchpointDTO = touchpointDTO;
    }

    public List<TouchpointDTO> getTouchpointDTOs() {
        return touchpointDTOs;
    }

    public void setTouchpointDTOs(List<TouchpointDTO> touchpointDTOs) {
        this.touchpointDTOs = touchpointDTOs;
    }

    public String getNamaTouchpoint() {
        return namaTouchpoint;
    }

    public void setNamaTouchpoint(String namaTouchpoint) {
        this.namaTouchpoint = namaTouchpoint;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public String getTouchpointID() {
        return touchpointID;
    }

    public void setTouchpointID(String touchpointID) {
        this.touchpointID = touchpointID;
    }

}
