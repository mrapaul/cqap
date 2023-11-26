package com.lakeland.hl7.datamodel;

import org.jetbrains.annotations.*;

public abstract class HL7HandlerAdapter implements HL7Handler
{
    @Override
    public void onHL7Message(@NotNull HL7Message aHL7Message)
    {
        // empty
    }

    @Override
    public void onHL7Messages(@NotNull HL7Messages aHL7Messages)
    {
        // empty
    }



    @Override
    public void onHL7Order(@NotNull HL7Order aHL7Order)
    {
        // empty
    }

    @Override
    public void onHL7Orders(@NotNull HL7Orders aHL7Orders)
    {
        // empty
    }

    @Override
    public void onNewOrder(@NotNull NewOrder aNewOrder)
    {
        // empty
    }



    @Override
    public void onOrderBidLocation(@NotNull OrderBidLocation aOrderBidLocation)
    {
        // empty
    }

    @Override
    public void onOrderBidTelerad(@NotNull OrderBidTelerad aOrderBidTelerad)
    {
        // empty
    }

    @Override
    public void onOrderBidConfirm(@NotNull OrderBidConfirm aOrderBidConfirm)
    {
        // empty
    }

    @Override
    public void onOrderBidRejected(@NotNull OrderBidRejected aOrderBidRejected)
    {
        // empty
    }

    @Override
    public void onOrderStatusChange(@NotNull OrderStatusChange aOrderStatusChange)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotRequest(@NotNull AdministrationSnapshotRequest aAdministrationSnapshotRequest)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotBegin(@NotNull AdministrationSnapshotBegin aAdministrationSnapshotBegin)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotPart(@NotNull AdministrationSnapshotPart aAdministrationSnapshotPart)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotEnd(@NotNull AdministrationSnapshotEnd aAdministrationSnapshotEnd)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshot(@NotNull AdministrationSnapshot aAdministrationSnapshot)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotRequest(@NotNull RadiologistSnapshotRequest aRadiologistSnapshotRequest)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotBegin(@NotNull RadiologistSnapshotBegin aRadiologistSnapshotBegin)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotPart(@NotNull RadiologistSnapshotPart aRadiologistSnapshotPart)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotEnd(@NotNull RadiologistSnapshotEnd aRadiologistSnapshotEnd)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshot(@NotNull RadiologistSnapshot aRadiologistSnapshot)
    {
        // empty
    }

    @Override
    public void onHL7RawMessage(@NotNull HL7RawMessage aHL7RawMessage)
    {
        // empty
    }

    @Override
    public void onManualAssignOrder(@NotNull ManualAssignOrder aManualAssignOrder)
    {
        // empty
    }

    @Override
    public void onPullOrders(@NotNull PullOrders aPullOrders)
    {
        // empty
    }

    @Override
    public void onDeleteOrders(@NotNull DeleteOrders aDeleteOrders)
    {
        // empty
    }

    @Override
    public void onOrderUpdated(@NotNull OrderUpdated aOrderUpdated)
    {
        // empty
    }

    @Override
    public void onOrderActivities(@NotNull OrderActivities aOrderActivities)
    {
        // empty
    }

    @Override
    public void onNewOrders(@NotNull NewOrders aNewOrders)
    {
        // empty
    }

    @Override
    public void onAssignImage(@NotNull AssignImage aAssignImage)
    {
        // empty
    }

    @Override
    public void onCreateDicomOrder(@NotNull CreateDicomOrder aCreateDicomOrder)
    {
        // empty
    }

    @Override
    public void onUnknown(byte aMessageType, int aMessageLength, @NotNull byte[] aBytes)
    {
        // empty
    }
}