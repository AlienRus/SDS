package backend.application.dto;

import java.io.Serializable;
import java.util.List;

public class ListDto implements Serializable {
    private List<ListRequestDto> requests;
    private List<ListFileDto> files;
    private List<ListRuleDto> rules;
    private LotDto lot;
    private List<LotFileDto> lotFiles;
    private List<PositionDto> positions;

    public ListDto(List<ListRequestDto> requests, List<ListFileDto> files, List<ListRuleDto> rules, LotDto lot,
            List<LotFileDto> lotFiles, List<PositionDto> positions) {
        this.requests = requests;
        this.files = files;
        this.rules = rules;
        this.lot = lot;
        this.lotFiles = lotFiles;
        this.positions = positions;
    }

    public ListDto() {
    }

    public List<ListRequestDto> getRequests() {
        return requests;
    }

    public void setRequests(List<ListRequestDto> requests) {
        this.requests = requests;
    }

    public List<ListFileDto> getFiles() {
        return files;
    }

    public void setFiles(List<ListFileDto> files) {
        this.files = files;
    }

    public List<ListRuleDto> getRules() {
        return rules;
    }

    public void setRules(List<ListRuleDto> rules) {
        this.rules = rules;
    }

    public LotDto getLot() {
        return lot;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
    }

    public List<LotFileDto> getLotFiles() {
        return lotFiles;
    }

    public void setLotFiles(List<LotFileDto> lotFiles) {
        this.lotFiles = lotFiles;
    }

    public List<PositionDto> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDto> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "ListDto [requests=" + requests + ", files=" + files + ", rules=" + rules + ", lot=" + lot
                + ", lotFiles=" + lotFiles + ", positions=" + positions + "]";
    }

}
