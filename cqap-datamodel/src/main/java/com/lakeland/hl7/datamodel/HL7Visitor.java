package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;

public interface HL7Visitor
{
    void visit(@NotNull HL7Message aHL7Message);

    void visit(@NotNull HL7Messages aHL7Messages);



    void visit(@NotNull HL7Order aHL7Order);

    void visit(@NotNull HL7Orders aHL7Orders);

    void visit(@NotNull NewOrder aNewOrder);



    void visit(@NotNull OrderBidLocation aOrderBidLocation);

    void visit(@NotNull OrderBidTelerad aOrderBidTelerad);

    void visit(@NotNull OrderBidConfirm aOrderBidConfirm);

    void visit(@NotNull OrderBidRejected aOrderBidRejected);

    void visit(@NotNull OrderStatusChange aOrderStatusChange);

    void visit(@NotNull AdministrationSnapshotRequest aAdministrationSnapshotRequest);

    void visit(@NotNull AdministrationSnapshotBegin aAdministrationSnapshotBegin);

    void visit(@NotNull AdministrationSnapshotPart aAdministrationSnapshotPart);

    void visit(@NotNull AdministrationSnapshotEnd aAdministrationSnapshotEnd);

    void visit(@NotNull AdministrationSnapshot aAdministrationSnapshot);

    void visit(@NotNull RadiologistSnapshotRequest aRadiologistSnapshotRequest);

    void visit(@NotNull RadiologistSnapshotBegin aRadiologistSnapshotBegin);

    void visit(@NotNull RadiologistSnapshotPart aRadiologistSnapshotPart);

    void visit(@NotNull RadiologistSnapshotEnd aRadiologistSnapshotEnd);

    void visit(@NotNull RadiologistSnapshot aRadiologistSnapshot);

    void visit(@NotNull HL7RawMessage aHL7RawMessage);

    void visit(@NotNull ManualAssignOrder aManualAssignOrder);

    void visit(@NotNull PullOrders aPullOrders);

    void visit(@NotNull DeleteOrders aDeleteOrders);

    void visit(@NotNull OrderUpdated aOrderUpdated);

    void visit(@NotNull OrderActivities aOrderActivities);

    void visit(@NotNull NewOrders aNewOrders);

    void visit(@NotNull AssignImage aAssignImage);

    void visit(@NotNull CreateDicomOrder aCreateDicomOrder);
}