package com.agit.crm.main.viewmodel.customer.kuesioner;

import com.agit.crm.common.application.PertanyaanOpsiService;
import com.agit.crm.common.application.PertanyaanService;
import com.agit.crm.common.application.TouchpointService;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanDTO;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanDTOBuilder;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanOpsiDTO;
import com.agit.crm.common.dto.customer.kuesioner.PertanyaanOpsiDTOBuilder;
import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTO;
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
public class PertanyaanVM {

    @WireVariable
    PertanyaanService pertanyaanService;

    @WireVariable
    PertanyaanOpsiService pertanyaanOpsiService;

    @WireVariable
    TouchpointService touchpointService;

    @WireVariable
    UserService userService;

    private PertanyaanDTO pertanyaanDTO = new PertanyaanDTO();
    private List<PertanyaanDTO> pertanyaanDTOs = new ArrayList<>();
    private List<String> listTouchpoint = new ArrayList<>();
    private String namaPertanyaan;
    private String touchpoint;

    private PertanyaanOpsiDTO pertanyaanOpsiDTO = new PertanyaanOpsiDTO();
    private List<PertanyaanOpsiDTO> pertanyaanOpsiDTOs = new ArrayList<>();

    private TouchpointDTO touchpointDTO = new TouchpointDTO();
    private List<TouchpointDTO> touchpointDTOs = new ArrayList<>();

    private UserDTO user;

    private PageNavigation previous;
    private String pertanyaanID;

    @Init
    public void init(
            @ExecutionArgParam("pertanyaanDTO") PertanyaanDTO pertanyaan,
            @ExecutionArgParam("pertanyaanOpsiDTO") PertanyaanOpsiDTO opsi,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(pertanyaan, opsi, previous);

    }

    private void initData() {
        pertanyaanDTOs = pertanyaanService.findAll();
        user = userService.findByID(SecurityUtil.getUserName());
        touchpointDTOs = touchpointService.findAll();
        for (TouchpointDTO d : touchpointDTOs) {
            listTouchpoint.add(d.getTouchpoint());
        }
    }

    private void checkValidity(PertanyaanDTO pertanyaan, PertanyaanOpsiDTO opsi, PageNavigation previous) {
        if (pertanyaan == null) {
            ListModelList<PertanyaanDTO> parameterList = new ListModelList<>(pertanyaanService.findAll());
            String pertanyaanID = "";
            if (parameterList.isEmpty()) {
                pertanyaanID = "Q001";
            } else {
                pertanyaanID = getLatestObjectID(parameterList, "pertanyaanID");
            }
            pertanyaanDTO = new PertanyaanDTOBuilder()
                    .setPertanyaanID(pertanyaanID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createPertanyaanDTO();
        } else {
            this.pertanyaanDTO = pertanyaan;
            pertanyaanID = pertanyaanDTO.getPertanyaanID();
            namaPertanyaan = pertanyaanDTO.getPertanyaan();
            touchpoint = pertanyaanDTO.getTouchpoint();
            this.previous = previous;
        }
        pertanyaanOpsiDTOs = pertanyaanOpsiService.findOpsiByPertanyaan(pertanyaanID);
    }

    @GlobalCommand
    @NotifyChange("pertanyaanDTOs")
    public void refreshDataPertanyaan() {
        pertanyaanDTOs = pertanyaanService.findAll();
    }

    @GlobalCommand
    @NotifyChange("pertanyaanOpsiDTOs")
    public void refreshDataAnswer() {
        pertanyaanOpsiDTOs = pertanyaanOpsiService.findAll();
    }

    @Command("buttonTambahPertanyaan")
    @NotifyChange("pertanyaanDTO")
    public void buttonTambahPertanyaan(@BindingParam("object") PertanyaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("pertanyaanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-kuesioner/tambah_pertanyaan.zul", window, params);
    }

    @Command("ubahPertanyaan")
    @NotifyChange("pertanyaanDTO")
    public void ubahPertanyaan(@BindingParam("object") PertanyaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("pertanyaanDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-kuesioner/tambah_pertanyaan.zul", window, params);
    }

    @Command("detailPertanyaan")
    @NotifyChange({"pertanyaanDTO", "pertanyaanOpsiDTOs"})
    public void detailPertanyaan(@BindingParam("object") PertanyaanDTO obj, List<PertanyaanOpsiDTO> objs, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("pertanyaanDTO", obj);
        params.put("pertanyaanOpsiDTOs", objs);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-kuesioner/detail_pertanyaan.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"questionDTO", "questionDTOs"})
    public void buttonKembali(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSavePertanyaan")
    @NotifyChange({"pertanyaanDTO", "pertanyaanDTOs"})
    public void buttonSavePertanyaan(@BindingParam("object") PertanyaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        pertanyaanDTO.setPertanyaan(namaPertanyaan);
        pertanyaanDTO.setTouchpoint(touchpoint);
        pertanyaanService.saveOrUpdate(pertanyaanDTO);
        showInformationMessagebox("Data Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataPertanyaan", null);
        window.detach();
    }

    @Command("buttonUbahPertanyaan")
    @NotifyChange({"pertanyaanDTO", "pertanyaanDTOs"})
    public void buttonUbahPertanyaan(@BindingParam("object") PertanyaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {

        pertanyaanDTO.setPertanyaan(namaPertanyaan);
        pertanyaanDTO.setTouchpoint(touchpoint);
        pertanyaanDTO.setModifiedBy(SecurityUtil.getUserName());
        pertanyaanDTO.setModifiedDate(new Date());
        pertanyaanService.saveOrUpdate(pertanyaanDTO);
        showInformationMessagebox("Data Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataPertanyaan", null);
        window.detach();
    }

    @Command("deletePertanyaan")
    @NotifyChange("pertanyaanDTO")
    public void deletePertanyaan(@BindingParam("object") PertanyaanDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        pertanyaanDTO = (PertanyaanDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Pertanyaan ini?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
                    @Override
                    public void onEvent(Event evt) throws InterruptedException {
                        if (evt.getName().equals("onOK")) {
                            pertanyaanService.deleteData(pertanyaanDTO);
                            showInformationMessagebox("Pertanyaan Berhasil Dihapus");
                            BindUtils.postGlobalCommand(null, null, "refreshDataPertanyaan", null);
                        } else {
                            System.out.println("Operasi dibatalkan");
                        }
                    }
                }
        );

    }

    @Command("buttonAddRowOpsi")
    @NotifyChange("pertanyaanOpsiDTOs")
    public void buttonAddRowOpsi(@ContextParam(ContextType.VIEW) Window window) {
        ListModelList<PertanyaanOpsiDTO> parameterList = new ListModelList<>(pertanyaanOpsiService.findAll());
        String pertanyaanOpsiID = "";
        if (parameterList.isEmpty()) {
            pertanyaanOpsiID = "P001";
        } else {
            pertanyaanOpsiID = getLatestObjectID(parameterList, "pertanyaanOpsiID");
        }
        PertanyaanOpsiDTO po = new PertanyaanOpsiDTOBuilder()
                .setPertanyaanOpsiID(pertanyaanOpsiID)
                .setPertanyaanID(pertanyaanDTO.getPertanyaanID())
                .setCreatedBy(SecurityUtil.getUserName())
                .setCreatedDate(new Date())
                .createPertanyaanOpsiDTO();
        pertanyaanOpsiDTOs.add(po);
    }

    @Command("buttonSavePertanyaanOpsi")
    @NotifyChange({"pertanyaanOpsiDTO", "pertanyaanOpsiDTOs"})
    public void buttonSavePertanyaanOpsi(@BindingParam("object") PertanyaanOpsiDTO obj, @ContextParam(ContextType.VIEW) Window window) {

        for (PertanyaanOpsiDTO p : pertanyaanOpsiDTOs) {
            pertanyaanOpsiService.saveOrUpdate(p);
        }
        showInformationMessagebox("Data Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataPertanyaanOpsi", null);
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

    public PertanyaanDTO getPertanyaanDTO() {
        return pertanyaanDTO;
    }

    public void setPertanyaanDTO(PertanyaanDTO pertanyaanDTO) {
        this.pertanyaanDTO = pertanyaanDTO;
    }

    public List<PertanyaanDTO> getPertanyaanDTOs() {
        return pertanyaanDTOs;
    }

    public void setPertanyaanDTOs(List<PertanyaanDTO> pertanyaanDTOs) {
        this.pertanyaanDTOs = pertanyaanDTOs;
    }

    public List<String> getListTouchpoint() {
        return listTouchpoint;
    }

    public void setListTouchpoint(List<String> listTouchpoint) {
        this.listTouchpoint = listTouchpoint;
    }

    public PertanyaanOpsiDTO getPertanyaanOpsiDTO() {
        return pertanyaanOpsiDTO;
    }

    public void setPertanyaanOpsiDTO(PertanyaanOpsiDTO pertanyaanOpsiDTO) {
        this.pertanyaanOpsiDTO = pertanyaanOpsiDTO;
    }

    public List<PertanyaanOpsiDTO> getPertanyaanOpsiDTOs() {
        return pertanyaanOpsiDTOs;
    }

    public void setPertanyaanOpsiDTOs(List<PertanyaanOpsiDTO> pertanyaanOpsiDTOs) {
        this.pertanyaanOpsiDTOs = pertanyaanOpsiDTOs;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public String getPertanyaanID() {
        return pertanyaanID;
    }

    public void setPertanyaanID(String pertanyaanID) {
        this.pertanyaanID = pertanyaanID;
    }

    public String getNamaPertanyaan() {
        return namaPertanyaan;
    }

    public void setNamaPertanyaan(String namaPertanyaan) {
        this.namaPertanyaan = namaPertanyaan;
    }

    public String getTouchpoint() {
        return touchpoint;
    }

    public void setTouchpoint(String touchpoint) {
        this.touchpoint = touchpoint;
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

}
