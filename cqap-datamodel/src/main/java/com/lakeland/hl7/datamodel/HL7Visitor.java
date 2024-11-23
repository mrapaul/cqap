package com.lakeland.hl7.datamodel;



public interface HL7Visitor
{
    void visit(HL7Message aHL7Message);

    void visit(HL7Messages aHL7Messages);



    void visit(HL7Order aHL7Order);

    void visit(HL7Orders aHL7Orders);

    void visit(NewOrder aNewOrder);



    void visit(OrderBidLocation aOrderBidLocation);

    void visit(OrderBidTelerad aOrderBidTelerad);

    void visit(OrderBidConfirm aOrderBidConfirm);

    void visit(OrderBidRejected aOrderBidRejected);

    void visit(OrderStatusChange aOrderStatusChange);

    void visit(AdministrationSnapshotRequest aAdministrationSnapshotRequest);

    void visit(AdministrationSnapshotBegin aAdministrationSnapshotBegin);

    void visit(AdministrationSnapshotPart aAdministrationSnapshotPart);

    void visit(AdministrationSnapshotEnd aAdministrationSnapshotEnd);

    void visit(AdministrationSnapshot aAdministrationSnapshot);

    void visit(RadiologistSnapshotRequest aRadiologistSnapshotRequest);

    void visit(RadiologistSnapshotBegin aRadiologistSnapshotBegin);

    void visit(RadiologistSnapshotPart aRadiologistSnapshotPart);

    void visit(RadiologistSnapshotEnd aRadiologistSnapshotEnd);

    void visit(RadiologistSnapshot aRadiologistSnapshot);

    void visit(HL7RawMessage aHL7RawMessage);

    void visit(ManualAssignOrder aManualAssignOrder);

    void visit(PullOrders aPullOrders);

    void visit(DeleteOrders aDeleteOrders);

    void visit(OrderUpdated aOrderUpdated);

    void visit(OrderActivities aOrderActivities);

    void visit(NewOrders aNewOrders);

    void visit(AssignImage aAssignImage);

    void visit(CreateDicomOrder aCreateDicomOrder);
}