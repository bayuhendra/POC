package com.agit.crm.main.viewmodel.customer.feedback;

import com.agit.crm.common.application.AnswerService;
import com.agit.crm.common.application.QuestionService;
import com.agit.crm.common.application.ResultAnswerService;
import com.agit.crm.common.application.TouchpointService;
import com.agit.crm.common.dto.customer.feedback.AnswerDTO;
import com.agit.crm.common.dto.customer.feedback.AnswerDTOBuilder;
import com.agit.crm.common.dto.customer.feedback.QuestionDTO;
import com.agit.crm.common.dto.customer.feedback.QuestionDTOBuilder;
import com.agit.crm.common.dto.customer.feedback.ResultAnswerDTO;
import com.agit.crm.common.dto.customer.feedback.ResultAnswerDTOBuilder;
import com.agit.crm.common.dto.customer.touchpoint.TouchpointDTO;
import com.agit.crm.common.dto.usermanagement.UserDTO;
import com.agit.crm.common.security.SecurityUtil;
import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import com.agit.crm.shared.zul.CommonViewModel;
import static com.agit.crm.shared.zul.CommonViewModel.showInformationMessagebox;
import com.agit.crm.shared.zul.PageNavigation;
import com.agit.crm.user.management.application.UserService;
import com.agit.crm.util.CommonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
 * @author BayuHS
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class QuestionVM {

    @WireVariable
    QuestionService questionService;

    @WireVariable
    AnswerService answerService;

    @WireVariable
    UserService userService;

    @WireVariable
    ResultAnswerService resultAnswerService;

    private QuestionDTO questionDTO = new QuestionDTO();
    private List<QuestionDTO> questionDTOs = new ArrayList<>();
    private List<QuestionDTO> questionDTOsType1 = new ArrayList<>();
    private List<QuestionDTO> questionDTOsType2 = new ArrayList<>();

    private AnswerDTO answerDTO = new AnswerDTO();
    private List<AnswerDTO> answerDTOs = new ArrayList<>();
    private List<AnswerDTO> answerType1DTOs = new ArrayList<>();
    private List<AnswerDTO> answerType2DTOs = new ArrayList<>();

    private List<String> listQuestion = new ArrayList<String>();
    private ListModelList<TypeTouchpoints> touchpointses = new ListModelList<>();

    private List<UserDTO> userDTOs = new ArrayList<>();
    private UserDTO userDTO = new UserDTO();

    private ResultAnswerDTO resultAnswerDTO;
    private List<ResultAnswerDTO> resultAnswerDTOs = new ArrayList<>();

    private UserDTO user;

    private String questionID;
    private String answerID;
    private String userID;
    private Status status;
    private TypeTouchpoints touchpoints;

    private String resultAnswerID;

    private PageNavigation previous;

    @Init
    public void init(
            @ExecutionArgParam("questionDTO") QuestionDTO question,
            @ExecutionArgParam("answerDTO") AnswerDTO answer,
            @ExecutionArgParam("resultAnswerDTO") ResultAnswerDTO resultAnswer,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();

        checkValidity(question, answer, resultAnswer, previous);

    }

    private void initData() {
        questionDTOs = questionService.findAll();
        if (questionDTOs.isEmpty()) {
            questionDTOs = Collections.emptyList();
        }

        questionDTOs = questionService.findAll();
        for (QuestionDTO m : questionDTOs) {
            listQuestion.add(m.getQuestion());
        }

        answerDTOs = answerService.findAll();
        if (answerDTOs.isEmpty()) {
            answerDTOs = Collections.emptyList();
        }

        answerType1DTOs = answerService.findAnswerByTouchPoints(TypeTouchpoints.TouchPoint_1);
        answerType2DTOs = answerService.findAnswerByTouchPoints(TypeTouchpoints.TouchPoint_2);

        user = userService.findByID(SecurityUtil.getUserName());
    }

    private void checkValidity(QuestionDTO question, AnswerDTO answer, ResultAnswerDTO resultAnswer, PageNavigation previous) {
        if (question == null) {
            ListModelList<QuestionDTO> parameterList = new ListModelList<>(questionService.findAll());
            String questionID = "";
            if (parameterList.isEmpty()) {
                questionID = "Question1";
            } else {
                questionID = getLatestObjectID(parameterList, "questionID");
            }
            questionDTO = new QuestionDTOBuilder()
                    .setQuestionID(questionID)
                    .setCreatedBy(SecurityUtil.getUserName())
                    .setCreatedDate(new Date())
                    .createQuestionDTO();
        } else {
            this.questionDTO = question;
            questionID = questionDTO.getQuestionID();
            this.previous = previous;
        }

        if (answer == null) {
            ListModelList<AnswerDTO> parameterList = new ListModelList<>(answerService.findAll());
            String answerID = "";
            if (parameterList.isEmpty()) {
                answerID = "1";
            } else {
                answerID = getLatestObjectID(parameterList, "answerID");
            }
            answerDTO = new AnswerDTOBuilder()
                    .setAnswerID(answerID)
                    .setIdChooseAnswer1(UUID.randomUUID().toString())
                    .setIdChooseAnswer2(UUID.randomUUID().toString())
                    .setIdChooseAnswer3(UUID.randomUUID().toString())
                    .setIdChooseAnswer4(UUID.randomUUID().toString())
                    .setIdChooseAnswer5(UUID.randomUUID().toString())
                    .setCreatedDate(new Date())
                    .createAnswerDTO();
        } else {
            this.answerDTO = answer;
            answerID = answerDTO.getAnswerID();
            this.previous = previous;
        }

        if (resultAnswer == null) {
            ListModelList<ResultAnswerDTO> parameterList = new ListModelList<>(resultAnswerService.findAll());
            if (parameterList.isEmpty()) {
                resultAnswerID = "1";
            }
            resultAnswerDTO = new ResultAnswerDTOBuilder()
                    .setResultAnswerID(resultAnswerID)
                    .setCreatedDate(new Date())
                    .createResultAnswerDTO();
        }
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

    @Command("buttonView1")
    @NotifyChange("question")
    public void buttonView1(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-1.zul", window, params);
    }

    @Command("buttonView2")
    @NotifyChange("question")
    public void buttonView2(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-2.zul", window, params);
    }

    @GlobalCommand
    @NotifyChange("questionDTOs")
    public void refreshData() {
        questionDTOs = questionService.findAll();
    }

    @GlobalCommand
    @NotifyChange("answerDTOs")
    public void refreshDataAnswer() {
        answerDTOs = answerService.findAll();
    }

    @Command("buttonAddQuestion")
    @NotifyChange("questionDTO")
    public void buttonAddQuestion(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-question.zul", window, params);
    }

    @Command("buttonStep4")
    @NotifyChange("questionDTO")
    public void buttonStep4(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/dashboard1/step4.zul", window, params);
    }

    @Command("buttonStep6")
    @NotifyChange("questionDTO")
    public void buttonStep6(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/dashboard1/step7.zul", window, params);
    }

    @Command("buttonAddAnswer")
    @NotifyChange("questionDTO")
    public void buttonAddAnswer(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("answerDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-answer.zul", window, params);
    }

    @Command("detail")
    @NotifyChange("question")
    public void detail(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/add-question.zul", window, params);
    }

    @Command("buttonTp1")
    @NotifyChange("question")
    public void buttonTp1(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-1.zul", window, params);
    }

    @Command("buttonTp2")
    @NotifyChange("question")
    public void buttonTp2(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("questionDTO", obj);
        CommonViewModel.navigateToWithoutDetach("/customer-feedback-experience/setup-question/view-question-2.zul", window, params);
    }

    @Command("buttonKembali")
    @NotifyChange({"questionDTO", "questionDTOs"})
    public void buttonKembali(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonSaveQuestion")
    @NotifyChange({"questionDTO", "answerDTO", "answerDTOs"})
    public void buttonSaveQuestion(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        questionDTO.setStatus(Status.ACTIVE);
        questionService.SaveOrUpdate(questionDTO);

        showInformationMessagebox("Pertanyaan Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @Command("buttonSaveFeedback1")
    @NotifyChange({"questionDTO", "resultAnswerDTO", "answerDTOs", "answerDTO"})
    public void buttonSaveFeedback1(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        String message = "";

        resultAnswerDTO.setResultAnswerID(UUID.randomUUID().toString());
        resultAnswerDTO.setAnswerID(answerDTO.getAnswerID());
        resultAnswerDTO.setTouchpoints(touchpoints.TouchPoint_1);
        resultAnswerService.SaveOrUpdate(resultAnswerDTO);
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
    }

    @Command("buttonFinishFeedback1")
    @NotifyChange({"questionDTO", "resultAnswerDTO", "answerDTOs", "answerDTO"})
    public void buttonFinishFeedback1(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {

        final String username = "bayuhendra1078@gmail.com";
        final String passwordEmail = "bayuhendra1993";
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwordEmail);
            }
        });
        try {

            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("bayuhendra1078@gmail.com"));
            message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resultAnswerDTO.getEmail()));

            message1.setSubject("Survei Kepuasan Pelanggan");
            message1.setSubject("Survei Kepuasan Pelanggan");
            message1.setText("\n Dear  Bapak/Ibu " + resultAnswerDTO.getNama()
                    + "\n\n FWD mengucapkan terima kasih atas feedback yang ada berikan di " + resultAnswerDTO.getTouchpoints()
                    + "\n\n Terimakasih untuk partisipasi anda."
                    + "\n "
                    + "\n\n Best Regards "
                    + "\n\n FWD "
            );
            message1.setSentDate(new Date());

            Transport.send(message1);

            System.out.println("==================Sending Email Done==================");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @Command("buttonSaveFeedback2")
    @NotifyChange({"questionDTO", "resultAnswerDTO", "answerDTOs", "answerDTO"})
    public void buttonSaveFeedback2(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        String message = "";

        resultAnswerDTO.setResultAnswerID(UUID.randomUUID().toString());
        resultAnswerDTO.setAnswerID(answerDTO.getAnswerID());
        resultAnswerDTO.setTouchpoints(touchpoints.TouchPoint_2);
        resultAnswerService.SaveOrUpdate(resultAnswerDTO);

        BindUtils.postGlobalCommand(null, null, "refreshData", null);
    }

    @Command("buttonFinishFeedback2")
    @NotifyChange({"questionDTO", "resultAnswerDTO", "answerDTOs", "answerDTO"})
    public void buttonFinishFeedback2(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        final String username = "bayuhendra1078@gmail.com";
        final String passwordEmail = "bayuhendra1993";
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwordEmail);
            }
        });
        try {

            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("bayuhendra1078@gmail.com"));
            message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resultAnswerDTO.getEmail()));

            message1.setSubject("Survei Kepuasan Pelanggan");
            message1.setSubject("Survei Kepuasan Pelanggan");
            message1.setText("\n Dear  Bapak/Ibu " + resultAnswerDTO.getNama()
                    + "\n\n FWD mengucapkan terima kasih atas feedback yang ada berikan di " + resultAnswerDTO.getTouchpoints()
                    + "\n\n Terimakasih untuk partisipasi anda."
                    + "\n "
                    + "\n\n Best Regards "
                    + "\n\n FWD "
            );
            message1.setSentDate(new Date());

            Transport.send(message1);

            System.out.println("==================Sending Email Done==================");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        BindUtils.postGlobalCommand(null, null, "refreshData", null);
        window.detach();
    }

    @Command("buttonSaveAnswer")
    @NotifyChange({"answerDTO", "questionDTO"})
    public void buttonSaveAnswer(@BindingParam("object") AnswerDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        answerService.SaveOrUpdate(answerDTO);
        showInformationMessagebox("Berhasil Disimpan");
        BindUtils.postGlobalCommand(null, null, "refreshDataAnswer", null);
        window.detach();
    }

    @Command("delete")
    @NotifyChange("questionDTO")
    public void delete(@BindingParam("object") QuestionDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        questionDTO = (QuestionDTO) obj;

        Messagebox.show("Apakah anda yakin ingin menghapus Pertanyaan?", "Konfirmasi", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION,
                new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws InterruptedException {
                if (evt.getName().equals("onOK")) {
                    questionService.deleteData(questionDTO);
                    showInformationMessagebox("Pertanyaan Berhasil Dihapus");
                    BindUtils.postGlobalCommand(null, null, "refreshData", null);
                } else {
                    System.out.println("Operasi dibatalkan");
                }
            }
        }
        );

    }

    public QuestionDTO getQuestionDTO() {
        return questionDTO;
    }

    public void setQuestionDTO(QuestionDTO questionDTO) {
        this.questionDTO = questionDTO;
    }

    public List<QuestionDTO> getQuestionDTOs() {
        return questionDTOs;
    }

    public void setQuestionDTOs(List<QuestionDTO> questionDTOs) {
        this.questionDTOs = questionDTOs;
    }

    public ListModelList<TypeTouchpoints> getTouchpointses() {
        return new ListModelList<>(TypeTouchpoints.values());
    }

    public void setTouchpointses(ListModelList<TypeTouchpoints> touchpointses) {
        this.touchpointses = touchpointses;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TypeTouchpoints getTouchpoints() {
        return touchpoints;
    }

    public void setTouchpoints(TypeTouchpoints touchpoints) {
        this.touchpoints = touchpoints;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public List<String> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<String> listQuestion) {
        this.listQuestion = listQuestion;
    }

    public List<QuestionDTO> getQuestionDTOsType1() {
        return questionDTOsType1;
    }

    public void setQuestionDTOsType1(List<QuestionDTO> questionDTOsType1) {
        this.questionDTOsType1 = questionDTOsType1;
    }

    public List<QuestionDTO> getQuestionDTOsType2() {
        return questionDTOsType2;
    }

    public void setQuestionDTOsType2(List<QuestionDTO> questionDTOsType2) {
        this.questionDTOsType2 = questionDTOsType2;
    }

    public AnswerDTO getAnswerDTO() {
        return answerDTO;
    }

    public void setAnswerDTO(AnswerDTO answerDTO) {
        this.answerDTO = answerDTO;
    }

    public List<AnswerDTO> getAnswerDTOs() {
        return answerDTOs;
    }

    public void setAnswerDTOs(List<AnswerDTO> answerDTOs) {
        this.answerDTOs = answerDTOs;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<AnswerDTO> getAnswerType1DTOs() {
        return answerType1DTOs;
    }

    public void setAnswerType1DTOs(List<AnswerDTO> answerType1DTOs) {
        this.answerType1DTOs = answerType1DTOs;
    }

    public List<AnswerDTO> getAnswerType2DTOs() {
        return answerType2DTOs;
    }

    public void setAnswerType2DTOs(List<AnswerDTO> answerType2DTOs) {
        this.answerType2DTOs = answerType2DTOs;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public ResultAnswerDTO getResultAnswerDTO() {
        return resultAnswerDTO;
    }

    public void setResultAnswerDTO(ResultAnswerDTO resultAnswerDTO) {
        this.resultAnswerDTO = resultAnswerDTO;
    }

    public String getResultAnswerID() {
        return resultAnswerID;
    }

    public void setResultAnswerID(String resultAnswerID) {
        this.resultAnswerID = resultAnswerID;
    }

    public List<ResultAnswerDTO> getResultAnswerDTOs() {
        return resultAnswerDTOs;
    }

    public void setResultAnswerDTOs(List<ResultAnswerDTO> resultAnswerDTOs) {
        this.resultAnswerDTOs = resultAnswerDTOs;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}
