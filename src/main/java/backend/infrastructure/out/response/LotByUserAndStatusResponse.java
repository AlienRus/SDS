package backend.infrastructure.out.response;

import java.time.LocalDate;

import backend.application.dto.LotDto;

public class LotByUserAndStatusResponse {
    private Long id;
    private String name;
    private LocalDate openDate;
    private LocalDate closeDate;
    private String groupEts;
    private Integer totalRequests;

    public LotByUserAndStatusResponse(LotDto lotDto) {
        this.id = lotDto.getId();
        this.name = lotDto.getName();
        this.openDate = lotDto.getOpenDate();
        this.closeDate = lotDto.getCloseDate();
        this.groupEts = lotDto.getGroupEts().getGroupName();
        this.totalRequests = 0;
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

    public String getGroupEts() {
        return groupEts;
    }

    public void setGroupEts(String groupEts) {
        this.groupEts = groupEts;
    }

    public Integer getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Integer totalRequests) {
        this.totalRequests = totalRequests;
    }
}
