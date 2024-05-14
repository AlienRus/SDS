package backend.infrastructure.out.response;

import java.time.LocalDate;

import backend.application.dto.LotDto;

public class LotByGroupResponse {
    private Long id;
    private String name;
    private LocalDate openDate;
    private LocalDate closeDate;

    public LotByGroupResponse(LotDto lotDto) {
        this.id = lotDto.getId();
        this.name = lotDto.getName();
        this.openDate = lotDto.getOpenDate();
        this.closeDate = lotDto.getCloseDate();
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

}
