package backend.application.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class LotDto implements Serializable {
    private Long id;
    private String name;
    private LocalDate openDate;
    private LocalDate closeDate;
    private StatusDto status;
    private Boolean canOwnWay;
    private SupplySpecialistDto lotCreator;
    private LotRuleDto rules;
    private GroupEtDto groupEts;

    public LotDto() {

    }

    public LotDto(Long id, String name, LocalDate openDate, LocalDate closeDate, StatusDto status, Boolean canOwnWay,
            SupplySpecialistDto lotCreator, LotRuleDto rules, GroupEtDto groupEts) {
        this.id = id;
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.status = status;
        this.canOwnWay = canOwnWay;
        this.lotCreator = lotCreator;
        this.rules = rules;
        this.groupEts = groupEts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public StatusDto getStatus() {
        return status;
    }

    public Boolean getCanOwnWay() {
        return canOwnWay;
    }

    public SupplySpecialistDto getLotCreator() {
        return lotCreator;
    }

    public LotRuleDto getRules() {
        return rules;
    }

    public GroupEtDto getGroupEts() {
        return groupEts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotDto entity = (LotDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.openDate, entity.openDate) &&
                Objects.equals(this.closeDate, entity.closeDate) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.canOwnWay, entity.canOwnWay) &&
                Objects.equals(this.lotCreator, entity.lotCreator) &&
                Objects.equals(this.rules, entity.rules) &&
                Objects.equals(this.groupEts, entity.groupEts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, openDate, closeDate, status, canOwnWay, lotCreator, rules, groupEts);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "openDate = " + openDate + ", " +
                "closeDate = " + closeDate + ", " +
                "status = " + status + ", " +
                "canOwnWay = " + canOwnWay + ", " +
                "lotCreator = " + lotCreator + ", " +
                "rules = " + rules + ", " +
                "groupEts = " + groupEts + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public void setCanOwnWay(Boolean canOwnWay) {
        this.canOwnWay = canOwnWay;
    }

    public void setLotCreator(SupplySpecialistDto lotCreator) {
        this.lotCreator = lotCreator;
    }

    public void setRules(LotRuleDto rules) {
        this.rules = rules;
    }

    public void setGroupEts(GroupEtDto groupEts) {
        this.groupEts = groupEts;
    }
}