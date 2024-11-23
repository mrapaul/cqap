package com.lakeland.hl7.datamodel;



public interface HL7Handler
{
    void onHL7Message(HL7Message aHL7Message);

    void onHL7Messages(HL7Messages aHL7Messages);



    void onHL7Order(HL7Order aHL7Order);

    void onHL7Orders(HL7Orders aHL7Orders);

    void onNewOrder(NewOrder aNewOrder);



    void onOrderBidLocation(OrderBidLocation aOrderBidLocation);

    void onOrderBidTelerad(OrderBidTelerad aOrderBidTelerad);

    void onOrderBidConfirm(OrderBidConfirm aOrderBidConfirm);

    void onOrderBidRejected(OrderBidRejected aOrderBidRejected);

    void onOrderStatusChange(OrderStatusChange aOrderStatusChange);

    void onAdministrationSnapshotRequest(AdministrationSnapshotRequest aAdministrationSnapshotRequest);

    void onAdministrationSnapshotBegin(AdministrationSnapshotBegin aAdministrationSnapshotBegin);

    void onAdministrationSnapshotPart(AdministrationSnapshotPart aAdministrationSnapshotPart);

    void onAdministrationSnapshotEnd(AdministrationSnapshotEnd aAdministrationSnapshotEnd);

    void onAdministrationSnapshot(AdministrationSnapshot aAdministrationSnapshot);

    void onRadiologistSnapshotRequest(RadiologistSnapshotRequest aRadiologistSnapshotRequest);

    void onRadiologistSnapshotBegin(RadiologistSnapshotBegin aRadiologistSnapshotBegin);

    void onRadiologistSnapshotPart(RadiologistSnapshotPart aRadiologistSnapshotPart);

    void onRadiologistSnapshotEnd(RadiologistSnapshotEnd aRadiologistSnapshotEnd);

    void onRadiologistSnapshot(RadiologistSnapshot aRadiologistSnapshot);

    void onHL7RawMessage(HL7RawMessage aHL7RawMessage);

    void onManualAssignOrder(ManualAssignOrder aManualAssignOrder);

    void onPullOrders(PullOrders aPullOrders);

    void onDeleteOrders(DeleteOrders aDeleteOrders);

    void onOrderUpdated(OrderUpdated aOrderUpdated);

    void onOrderActivities(OrderActivities aOrderActivities);

    void onNewOrders(NewOrders aNewOrders);

    void onAssignImage(AssignImage aAssignImage);

    void onCreateDicomOrder(CreateDicomOrder aCreateDicomOrder);

    void onUnknown(byte aMessageType, int aMessageLength, byte[] aBytes);
}