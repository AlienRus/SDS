package backend.infrastructure.in.rest.request;

import java.time.LocalDate;

public class LotRequestDto {
    private Long id;
    private String name;
    private LocalDate openDate;
    private LocalDate closeDate;
    private Long statusId;
    private boolean canOwnWay;
    private Long lotCreatorId;
    private Long groupEtsId;
    private LotRuleRequestDto rules;
    private LotFileRequestDto lotFiles;

    public LotRequestDto(Long id, String name, LocalDate openDate, LocalDate closeDate, Long statusId,
            boolean canOwnWay, Long lotCreatorId, Long groupEtsId, LotRuleRequestDto rules,
            LotFileRequestDto lotFiles) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.statusId = statusId;
        this.canOwnWay = canOwnWay;
        this.lotCreatorId = lotCreatorId;
        this.groupEtsId = groupEtsId;
        this.rules = rules;
        this.lotFiles = lotFiles;
    }

    public LotRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isCanOwnWay() {
        return canOwnWay;
    }

    public void setCanOwnWay(boolean canOwnWay) {
        this.canOwnWay = canOwnWay;
    }

    public Long getLotCreatorId() {
        return lotCreatorId;
    }

    public void setLotCreatorId(Long lotCreatorId) {
        this.lotCreatorId = lotCreatorId;
    }

    public Long getGroupEtsId() {
        return groupEtsId;
    }

    public void setGroupEtsId(Long groupEtsId) {
        this.groupEtsId = groupEtsId;
    }

    public LotRuleRequestDto getRules() {
        return rules;
    }

    public void setRules(LotRuleRequestDto rules) {
        this.rules = rules;
    }

    public LotFileRequestDto getLotFiles() {
        return lotFiles;
    }

    public void setLotFiles(LotFileRequestDto lotFiles) {
        this.lotFiles = lotFiles;
    }

    @Override
    public String toString() {
        return "LotRequestDto [id=" + id + ", name=" + name + ", openDate=" + openDate + ", closeDate=" + closeDate
                + ", statusId=" + statusId + ", canOwnWay=" + canOwnWay + ", lotCreatorId=" + lotCreatorId
                + ", groupEtsId=" + groupEtsId + ", rules=" + rules + ", lotFiles=" + lotFiles + "]";
    }

}
