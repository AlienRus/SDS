package backend.infrastructure.in.rest.request.put.lot;

import java.time.LocalDate;

public class UpdateLotRequest {
    private String name;
    private LocalDate openDate;
    private LocalDate closeDate;
    private Long statusId;
    private Boolean canOwnWay;
    private Rules rules;
    private String filePath;

    public UpdateLotRequest(String name, LocalDate openDate, LocalDate closeDate, Long statusId, Boolean canOwnWay,
            Rules rules, String filePath) {
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.statusId = statusId;
        this.canOwnWay = canOwnWay;
        this.rules = rules;
        this.filePath = filePath;
    }

    public UpdateLotRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Boolean getCanOwnWay() {
        return canOwnWay;
    }

    public void setCanOwnWay(Boolean canOwnWay) {
        this.canOwnWay = canOwnWay;
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
