package backend.application.dto;

import java.util.List;

public class ListDto {
    private List<RequestDto> requests;
    private List<ListFileDto> files;
    private List<ListRuleDto> rules;

    public ListDto(List<RequestDto> requests, List<ListFileDto> files, List<ListRuleDto> rules) {
        this.requests = requests;
        this.files = files;
        this.rules = rules;
    }

    public List<RequestDto> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestDto> requests) {
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
}
