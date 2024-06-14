package backend.infrastructure.builder;

import backend.application.interfaces.in.IGroupEtService;
import backend.application.interfaces.in.IGroupEtsSignerService;
import backend.application.interfaces.in.IListService;
import backend.application.interfaces.in.ILotFileService;
import backend.application.interfaces.in.ILotPositionService;
import backend.application.interfaces.in.ILotRuleService;
import backend.application.interfaces.in.ILotService;
import backend.application.interfaces.in.IPaymentMethodService;
import backend.application.interfaces.in.IPositionRequestService;
import backend.application.interfaces.in.IPositionService;
import backend.application.interfaces.in.IRequestFileService;
import backend.application.interfaces.in.IRequestRuleService;
import backend.application.interfaces.in.IRequestService;
import backend.application.interfaces.in.IRoleService;
import backend.application.interfaces.in.IShippingMethodService;
import backend.application.interfaces.in.IStaffService;
import backend.application.interfaces.in.IStatusService;
import backend.application.interfaces.in.ISupplierGroupService;
import backend.application.interfaces.in.ISupplierNotificationService;
import backend.application.interfaces.in.ISupplierService;
import backend.application.interfaces.in.ISupplySpecialistGroupService;
import backend.application.interfaces.in.ISupplySpecialistLotService;
import backend.application.interfaces.in.ISupplySpecialistService;
import backend.application.interfaces.in.ITypeOfBusinessService;
import backend.application.interfaces.out.repository.IGroupEtRepository;
import backend.application.interfaces.out.repository.IGroupEtsSignerRepository;
import backend.application.interfaces.out.repository.ILotFileRepository;
import backend.application.interfaces.out.repository.ILotPositionRepository;
import backend.application.interfaces.out.repository.ILotRepository;
import backend.application.interfaces.out.repository.ILotRuleRepository;
import backend.application.interfaces.out.repository.IPaymentMethodRepository;
import backend.application.interfaces.out.repository.IPositionRepository;
import backend.application.interfaces.out.repository.IPositionRequestRepository;
import backend.application.interfaces.out.repository.IRequestFileRepository;
import backend.application.interfaces.out.repository.IRequestRepository;
import backend.application.interfaces.out.repository.IRequestRuleRepository;
import backend.application.interfaces.out.repository.IRoleRepository;
import backend.application.interfaces.out.repository.IShippingMethodRepository;
import backend.application.interfaces.out.repository.IStaffRepository;
import backend.application.interfaces.out.repository.IStatusRepository;
import backend.application.interfaces.out.repository.ISupplierGroupRepository;
import backend.application.interfaces.out.repository.ISupplierNotificationRepository;
import backend.application.interfaces.out.repository.ISupplierRepository;
import backend.application.interfaces.out.repository.ISupplySpecialistGroupRepository;
import backend.application.interfaces.out.repository.ISupplySpecialistLotRepository;
import backend.application.interfaces.out.repository.ISupplySpecialistRepository;
import backend.application.interfaces.out.repository.ITypeOfBusinessRepository;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

public class Builder {

    @Inject
    @Default
    private IGroupEtRepository groupEtRepository;

    @Inject
    @Default
    private IGroupEtsSignerRepository groupEtsSignerRepository;

    @Inject
    @Default
    private ILotRepository lotRepository;

    @Inject
    @Default
    private ILotFileRepository lotFileRepository;

    @Inject
    @Default
    private ILotPositionRepository lotPositionRepository;

    @Inject
    @Default
    private ILotRuleRepository lotRuleRepository;

    @Inject
    @Default
    private IPaymentMethodRepository paymentMethodRepository;

    @Inject
    @Default
    private IPositionRepository positionRepository;

    @Inject
    @Default
    private IPositionRequestRepository positionRequestRepository;

    @Inject
    @Default
    private IRequestRepository requestRepository;

    @Inject
    @Default
    private IRequestFileRepository requestFileRepository;

    @Inject
    @Default
    private IRequestRuleRepository requestRuleRepository;

    @Inject
    @Default
    private IRoleRepository roleRepository;

    @Inject
    @Default
    private IShippingMethodRepository shippingMethodRepository;

    @Inject
    @Default
    private IStaffRepository staffRepository;

    @Inject
    @Default
    private IStatusRepository statusRepository;

    @Inject
    @Default
    private ISupplierRepository supplierRepository;

    @Inject
    @Default
    private ISupplierGroupRepository supplierGroupRepository;

    @Inject
    @Default
    private ISupplierNotificationRepository supplierNotificationRepository;

    @Inject
    @Default
    private ISupplySpecialistRepository supplySpecialistRepository;

    @Inject
    @Default
    private ISupplySpecialistGroupRepository supplySpecialistGroupRepository;

    @Inject
    @Default
    private ISupplySpecialistLotRepository supplySpecialistLotRepository;

    @Inject
    @Default
    private ITypeOfBusinessRepository typeOfBusinessRepository;

    @Inject
    @Default
    private IGroupEtService groupEtService;

    @Inject
    @Default
    private IGroupEtsSignerService groupEtsSignerService;

    @Inject
    @Default
    private ILotService lotService;

    @Inject
    @Default
    private ILotFileService lotFileService;

    @Inject
    @Default
    private ILotPositionService lotPositionService;

    @Inject
    @Default
    private ILotRuleService lotRuleService;

    @Inject
    @Default
    private IPaymentMethodService paymentMethodService;

    @Inject
    @Default
    private IPositionService positionService;

    @Inject
    @Default
    private IPositionRequestService positionRequestService;

    @Inject
    @Default
    private IRequestService requestService;

    @Inject
    @Default
    private IRequestFileService requestFileService;

    @Inject
    @Default
    private IRequestRuleService requestRuleService;

    @Inject
    @Default
    private IRoleService roleService;

    @Inject
    @Default
    private IShippingMethodService shippingMethodService;

    @Inject
    @Default
    private IStaffService staffService;

    @Inject
    @Default
    private IStatusService statusService;

    @Inject
    @Default
    private ISupplierService supplierService;

    @Inject
    @Default
    private ISupplierGroupService supplierGroupService;

    @Inject
    @Default
    private ISupplierNotificationService supplierNotificationService;

    @Inject
    @Default
    private ISupplySpecialistService supplySpecialistService;

    @Inject
    @Default
    private ISupplySpecialistGroupService supplySpecialistGroupService;

    @Inject
    @Default
    private ISupplySpecialistLotService supplySpecialistLotService;

    @Inject
    @Default
    private ITypeOfBusinessService typeOfBusinessService;

    @Inject
    @Default
    private IListService listService;

    @Produces
    @Built
    public IListService buildListService() {
        listService.InjectRepositories(lotPositionRepository, positionRequestRepository, requestFileRepository,
                requestRuleRepository, lotFileRepository);
        return listService;
    }

    @Produces
    @Built
    public IGroupEtService buildGroupEtService() {
        groupEtService.InjectGroupEtRepository(groupEtRepository);
        return groupEtService;
    }

    @Produces
    @Built
    public IGroupEtsSignerService buildGroupEtSignerService() {
        groupEtsSignerService.InjectGroupEtsSignerRepository(groupEtsSignerRepository);
        return groupEtsSignerService;
    }

    @Produces
    @Built
    public ILotService buildLotService() {
        lotService.InjectLotRepository(lotRepository, supplySpecialistRepository, statusRepository, groupEtRepository);
        return lotService;
    }

    @Produces
    @Built
    public ILotFileService buildLotFileService() {
        lotFileService.InjectLotFileRepository(lotFileRepository);
        return lotFileService;
    }

    @Produces
    @Built
    public ILotPositionService buildLotPositionService() {
        lotPositionService.InjectLotPositionRepository(lotPositionRepository);
        return lotPositionService;
    }

    @Produces
    @Built
    public ILotRuleService buildLotRuleService() {
        lotRuleService.InjectLotRuleRepository(lotRuleRepository);
        return lotRuleService;
    }

    @Produces
    @Built
    public IPaymentMethodService builPaymentMethodService() {
        paymentMethodService.InjectPaymentMethodRepository(paymentMethodRepository);
        return paymentMethodService;
    }

    @Produces
    @Built
    public IPositionService buildPositionService() {
        positionService.InjectPositionRepository(positionRepository);
        return positionService;
    }

    @Produces
    @Built
    public IPositionRequestService buildPositionRequestService() {
        positionRequestService.InjectPositionRequestRepository(positionRequestRepository);
        return positionRequestService;
    }

    @Produces
    @Built
    public IRequestService buildRequestService() {
        requestService.InjectRequestRepository(requestRepository);
        return requestService;
    }

    @Produces
    @Built
    public IRequestFileService buildRequestFileService() {
        requestFileService.InjectRequestFileRepository(requestFileRepository);
        return requestFileService;
    }

    @Produces
    @Built
    public IRequestRuleService buildRequestRuleService() {
        requestRuleService.InjectRequestRuleRepository(requestRuleRepository);
        return requestRuleService;
    }

    @Produces
    @Built
    public IRoleService buildRoleService() {
        roleService.InjectRoleRepository(roleRepository);
        return roleService;
    }

    @Produces
    @Built
    public IShippingMethodService builShippingMethodService() {
        shippingMethodService.InjectShippingMethodRepository(shippingMethodRepository);
        return shippingMethodService;
    }

    @Produces
    @Built
    public IStaffService buildStaffService() {
        staffService.InjectStaffRepository(staffRepository);
        return staffService;
    }

    @Produces
    @Built
    public IStatusService buildStatusService() {
        statusService.InjectStatusRepository(statusRepository);
        return statusService;
    }

    @Produces
    @Built
    public ISupplierService buildSupplierService() {
        supplierService.InjectSupplierRepository(supplierRepository);
        return supplierService;
    }

    @Produces
    @Built
    public ISupplierGroupService buildSupplierGroupService() {
        supplierGroupService.InjectSupplierGroupRepository(supplierGroupRepository);
        return supplierGroupService;
    }

    @Produces
    @Built
    public ISupplierNotificationService buildSupplierNotificationService() {
        supplierNotificationService.InjectSupplierNotificationRepository(supplierNotificationRepository);
        return supplierNotificationService;
    }

    @Produces
    @Built
    public ISupplySpecialistService buildSupplySpecialistService() {
        supplySpecialistService.InjectSupplySpecialistRepository(supplySpecialistRepository);
        return supplySpecialistService;
    }

    @Produces
    @Built
    public ISupplySpecialistGroupService buildSupplySpecialistGroupService() {
        supplySpecialistGroupService.InjectSupplySpecialistGroupRepository(supplySpecialistGroupRepository);
        return supplySpecialistGroupService;
    }

    @Produces
    @Built
    public ISupplySpecialistLotService buildSupplySpecialistLotService() {
        supplySpecialistLotService.InjectSupplySpecialistLotRepository(supplySpecialistLotRepository);
        return supplySpecialistLotService;
    }

    @Produces
    @Built
    public ITypeOfBusinessService buildTypeOfBusinessService() {
        typeOfBusinessService.InjectTypeOfBusinessRepository(typeOfBusinessRepository);
        return typeOfBusinessService;
    }

}
