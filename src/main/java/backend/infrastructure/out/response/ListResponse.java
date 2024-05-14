package backend.infrastructure.out.response;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.ListDto;
import backend.application.dto.ListFileDto;
import backend.application.dto.ListRuleDto;
import backend.application.dto.RequestDto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ListResponse {
    private List<ListRequestResponse> requests;
    private List<ListFilesResponse> files;
    private List<ListRulesResponse> rules;

    public ListResponse(ListDto listDto) {
        List<ListRequestResponse> listRequestResponses = new ArrayList<ListRequestResponse>();

        for (RequestDto requestDto : listDto.getRequests()) {
            listRequestResponses.add(new ListRequestResponse(requestDto.getId(), requestDto.getPriceForOne(),
                    requestDto.getCount(), requestDto.getItemName(), requestDto.getDeliveryTime(),
                    new ListSupplierResponse(requestDto.getSupplier().getId(), requestDto.getSupplier().getCompany())));
        }
        this.requests = listRequestResponses;

        List<ListFilesResponse> listFilesResponses = new ArrayList<ListFilesResponse>();

        for (ListFileDto listFileDto : listDto.getFiles()) {
            listFilesResponses.add(new ListFilesResponse(listFileDto.getPath(), listFileDto.getSupplierId()));
        }

        this.files = listFilesResponses;

        List<ListRulesResponse> listRulesResponses = new ArrayList<ListRulesResponse>();

        for (ListRuleDto listRuleDto : listDto.getRules()) {
            ListRulesResponse listRulesResponse = new ListRulesResponse(listRuleDto.getComment(),
                    new ListRulesPaymentResponse(listRuleDto.getPayment().getMethod(),
                            listRuleDto.getPayment().getValue()),
                    listRuleDto.getShippingMethod());
            Logger.getLogger(ListResponse.class.getName()).log(Level.WARNING,
                    listRulesResponse.toString());

            listRulesResponses.add(listRulesResponse);
        }

        this.rules = listRulesResponses;
    }

    public List<ListRequestResponse> getRequests() {
        return requests;
    }

    public void setRequests(List<ListRequestResponse> requests) {
        this.requests = requests;
    }

    public List<ListFilesResponse> getFiles() {
        return files;
    }

    public void setFiles(List<ListFilesResponse> files) {
        this.files = files;
    }

    public List<ListRulesResponse> getRules() {
        return rules;
    }

    public void setRules(List<ListRulesResponse> rules) {
        this.rules = rules;
    }
}
