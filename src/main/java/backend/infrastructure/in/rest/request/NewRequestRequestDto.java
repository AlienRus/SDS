package backend.infrastructure.in.rest.request;

import java.util.List;

public class NewRequestRequestDto {
    private List<NewRequestRequestDataDto> data;
    private NewRequestFileRequestDto requestFiles;
    private LotRuleRequestDto requestRules;

    public NewRequestRequestDto() {
    }

    public NewRequestRequestDto(List<NewRequestRequestDataDto> data, NewRequestFileRequestDto requestFiles,
            LotRuleRequestDto requestRules) {
        this.data = data;
        this.requestFiles = requestFiles;
        this.requestRules = requestRules;
    }

    public List<NewRequestRequestDataDto> getData() {
        return data;
    }

    public void setData(List<NewRequestRequestDataDto> data) {
        this.data = data;
    }

    public NewRequestFileRequestDto getRequestFiles() {
        return requestFiles;
    }

    public void setRequestFiles(NewRequestFileRequestDto requestFiles) {
        this.requestFiles = requestFiles;
    }

    public LotRuleRequestDto getRequestRules() {
        return requestRules;
    }

    public void setRequestRules(LotRuleRequestDto requestRules) {
        this.requestRules = requestRules;
    }

}
