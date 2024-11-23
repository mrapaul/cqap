package com.lakeland.hl7.datamodel;



public abstract class HL7HandlerAdapter implements HL7Handler
{
    @Override
    public void onHL7Message(HL7Message aHL7Message)
    {
        // empty
    }

    @Override
    public void onHL7Messages(HL7Messages aHL7Messages)
    {
        // empty
    }



    @Override
    public void onHL7Order(HL7Order aHL7Order)
    {
        // empty
    }

    @Override
    public void onHL7Orders(HL7Orders aHL7Orders)
    {
        // empty
    }

    @Override
    public void onNewOrder(NewOrder aNewOrder)
    {
        // empty
    }



    @Override
    public void onOrderBidLocation(OrderBidLocation aOrderBidLocation)
    {
        // empty
    }

    @Override
    public void onOrderBidTelerad(OrderBidTelerad aOrderBidTelerad)
    {
        // empty
    }

    @Override
    public void onOrderBidConfirm(OrderBidConfirm aOrderBidConfirm)
    {
        // empty
    }

    @Override
    public void onOrderBidRejected(OrderBidRejected aOrderBidRejected)
    {
        // empty
    }

    @Override
    public void onOrderStatusChange(OrderStatusChange aOrderStatusChange)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotRequest(AdministrationSnapshotRequest aAdministrationSnapshotRequest)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotBegin(AdministrationSnapshotBegin aAdministrationSnapshotBegin)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotPart(AdministrationSnapshotPart aAdministrationSnapshotPart)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshotEnd(AdministrationSnapshotEnd aAdministrationSnapshotEnd)
    {
        // empty
    }

    @Override
    public void onAdministrationSnapshot(AdministrationSnapshot aAdministrationSnapshot)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotRequest(RadiologistSnapshotRequest aRadiologistSnapshotRequest)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotBegin(RadiologistSnapshotBegin aRadiologistSnapshotBegin)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotPart(RadiologistSnapshotPart aRadiologistSnapshotPart)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshotEnd(RadiologistSnapshotEnd aRadiologistSnapshotEnd)
    {
        // empty
    }

    @Override
    public void onRadiologistSnapshot(RadiologistSnapshot aRadiologistSnapshot)
    {
        // empty
    }

    @Override
    public void onHL7RawMessage(HL7RawMessage aHL7RawMessage)
    {
        // empty
    }

    @Override
    public void onManualAssignOrder(ManualAssignOrder aManualAssignOrder)
    {
        // empty
    }

    @Override
    public void onPullOrders(PullOrders aPullOrders)
    {
        // empty
    }

    @Override
    public void onDeleteOrders(DeleteOrders aDeleteOrders)
    {
        // empty
    }

    @Override
    public void onOrderUpdated(OrderUpdated aOrderUpdated)
    {
        // empty
    }

    @Override
    public void onOrderActivities(OrderActivities aOrderActivities)
    {
        // empty
    }

    @Override
    public void onNewOrders(NewOrders aNewOrders)
    {
        // empty
    }

    @Override
    public void onAssignImage(AssignImage aAssignImage)
    {
        // empty
    }

    @Override
    public void onCreateDicomOrder(CreateDicomOrder aCreateDicomOrder)
    {
        // empty
    }

    @Override
    public void onUnknown(byte aMessageType, int aMessageLength, byte[] aBytes)
    {
        // empty
    }
}