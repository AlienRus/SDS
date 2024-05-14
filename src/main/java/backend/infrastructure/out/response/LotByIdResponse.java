package backend.infrastructure.out.response;

import java.time.LocalDate;

import backend.application.dto.LotDto;
import backend.application.dto.LotFileDto;

public class LotByIdResponse {
    private boolean canOwnWay;
    private LocalDate closeDate;
    private String groupEts;
    private Long id;
    private String lotCreator;
    private String name;
    private LocalDate openDate;
    private RulesResponse rules;
    private String status;
    private LotFilesResponse lotFiles;

    public LotByIdResponse(LotDto lotDto, LotFileDto lotFileDto) {
        this.canOwnWay = lotDto.getCanOwnWay();
        this.closeDate = lotDto.getCloseDate();
        this.groupEts = lotDto.getGroupEts().getGroupName();
        this.id = lotDto.getId();
        this.lotCreator = lotDto.getLotCreator().getCompany();
        this.name = lotDto.getName();
        this.openDate = lotDto.getOpenDate();
        this.rules = new RulesResponse(lotDto.getRules());
        this.status = lotDto.getStatus().getStatusName();
        if (lotFileDto == null) {
            this.lotFiles = null;
        } else {
            this.lotFiles = new LotFilesResponse(lotFileDto);
        }
    }

    public boolean isCanOwnWay() {
        return canOwnWay;
    }

    public void setCanOwnWay(boolean canOwnWay) {
        this.canOwnWay = canOwnWay;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public String getGroupEts() {
        return groupEts;
    }

    public void setGroupEts(String groupEts) {
        this.groupEts = groupEts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLotCreator() {
        return lotCreator;
    }

    public void setLotCreator(String lotCreator) {
        this.lotCreator = lotCreator;
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

    public RulesResponse getRules() {
        return rules;
    }

    public void setRules(RulesResponse rules) {
        this.rules = rules;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LotFilesResponse getLotFiles() {
        return lotFiles;
    }

    public void setLotFiles(LotFilesResponse lotFiles) {
        this.lotFiles = lotFiles;
    }

}
