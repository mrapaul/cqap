package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;

public interface HL7Handler
{
    void onHL7Message(@NotNull HL7Message aHL7Message);

    void onHL7Messages(@NotNull HL7Messages aHL7Messages);



    void onHL7Order(@NotNull HL7Order aHL7Order);

    void onHL7Orders(@NotNull HL7Orders aHL7Orders);

    void onNewOrder(@NotNull NewOrder aNewOrder);



    void onOrderBidLocation(@NotNull OrderBidLocation aOrderBidLocation);

    void onOrderBidTelerad(@NotNull OrderBidTelerad aOrderBidTelerad);

    void onOrderBidConfirm(@NotNull OrderBidConfirm aOrderBidConfirm);

    void onOrderBidRejected(@NotNull OrderBidRejected aOrderBidRejected);

    void onOrderStatusChange(@NotNull OrderStatusChange aOrderStatusChange);

    void onAdministrationSnapshotRequest(@NotNull AdministrationSnapshotRequest aAdministrationSnapshotRequest);

    void onAdministrationSnapshotBegin(@NotNull AdministrationSnapshotBegin aAdministrationSnapshotBegin);

    void onAdministrationSnapshotPart(@NotNull AdministrationSnapshotPart aAdministrationSnapshotPart);

    void onAdministrationSnapshotEnd(@NotNull AdministrationSnapshotEnd aAdministrationSnapshotEnd);

    void onAdministrationSnapshot(@NotNull AdministrationSnapshot aAdministrationSnapshot);

    void onRadiologistSnapshotRequest(@NotNull RadiologistSnapshotRequest aRadiologistSnapshotRequest);

    void onRadiologistSnapshotBegin(@NotNull RadiologistSnapshotBegin aRadiologistSnapshotBegin);

    void onRadiologistSnapshotPart(@NotNull RadiologistSnapshotPart aRadiologistSnapshotPart);

    void onRadiologistSnapshotEnd(@NotNull RadiologistSnapshotEnd aRadiologistSnapshotEnd);

    void onRadiologistSnapshot(@NotNull RadiologistSnapshot aRadiologistSnapshot);

    void onHL7RawMessage(@NotNull HL7RawMessage aHL7RawMessage);

    void onManualAssignOrder(@NotNull ManualAssignOrder aManualAssignOrder);

    void onPullOrders(@NotNull PullOrders aPullOrders);

    void onDeleteOrders(@NotNull DeleteOrders aDeleteOrders);

    void onOrderUpdated(@NotNull OrderUpdated aOrderUpdated);

    void onOrderActivities(@NotNull OrderActivities aOrderActivities);

    void onNewOrders(@NotNull NewOrders aNewOrders);

    void onAssignImage(@NotNull AssignImage aAssignImage);

    void onCreateDicomOrder(@NotNull CreateDicomOrder aCreateDicomOrder);

    void onUnknown(byte aMessageType, int aMessageLength, @NotNull byte[] aBytes);
}