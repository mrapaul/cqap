1. Ticket Creation
   UI Interaction:
   The user clicks the "Create New Ticket" button in the UI.
   Application Logic:
   The ClientRestService initializes a new ProfessionalTicket with the status set to NEW.
   The ClientRestService returns the new ticket to the UI.
2. Filling Initial Details (Status: NEW)
   UI Interaction:
   The user fills in the following fields in the UI:
   Ticket Title (text field)
   Description (text area)
   Category (dropdown selection)
   Priority (dropdown selection)
   The user clicks the "Save" button.
   Application Logic:
   The ClientRestService receives the data and validates the input.
   If validation fails:
   The ClientRestService returns a list of validation errors to the UI, which are displayed next to the corresponding fields.
   If validation succeeds:
   The ClientRestService saves the ticket to the database.
   The ProfessionalTicket status is updated to OPEN_ERP_REVIEW.
   The UI is updated to indicate success and navigates to the ERP Review section.
3. Completing ERP Review (Status: OPEN_ERP_REVIEW)
   UI Interaction:
   The user reviews the initial details.
   The user selects an ERP category from a dropdown.
   The user enters findings in the comments field.
   The user clicks the "Complete ERP Review" button.
   Application Logic:
   TicketTransitions validates the selected category and entered findings.
   If the category is invalid or comments are missing:
   An error message is displayed in the UI, prompting the user to correct the input.
   If the category is valid:
   The ProfessionalTicket processes the ERPReport.
   The system checks if the category is not equal to 1.
   If true, the system retrieves additional fact findings.
   If additional findings exist, the report quality and time are updated. The ProfessionalTicket status is set to OPEN_SITE_CALL_REQUIRED, and the ticket is saved.
   If no additional findings exist, the report quality is calculated.
   If the quality is less than 100 and no comments are provided, a message is displayed in the UI, prompting the user to enter quality comments.
   If the quality is valid, the report quality and time are updated. The ProfessionalTicket status is set to OPEN_PIR_REVIEW, and the ticket is saved.
   If false (category is 1), the report quality is calculated.
   If the quality is less than 100 and no comments are provided, a message is displayed in the UI, prompting the user to enter quality comments.
   If the quality is valid, the report quality and time are updated. The ProfessionalTicket status is set to COMPLETED, and the ticket is saved.
4. Completing PIR Review (Status: OPEN_PIR_REVIEW)
   UI Interaction:
   The user reviews the ERP report and findings.
   The user indicates agreement or disagreement with the IIRReport via a radio button or similar control.
   If disagreeing, the user enters comments in the provided text area.
   The user clicks the "Complete PIR Review" button.
   Application Logic:
   TicketTransitions checks the agreement status.
   If the user disagrees without providing comments:
   A message is displayed in the UI, prompting the user to provide comments.
   If the user agrees or provides valid disagreement comments:
   The report time is updated.
   The ProfessionalTicket status is set to either COMPLETED or OPEN_CMO_REVIEW, depending on the specific criteria.
   The ticket is saved.
5. Completing CMO Review (Status: OPEN_CMO_REVIEW)
   UI Interaction:
   The user reviews the ProfessionalTicket and associated reports.
   The user selects a CMO category from a dropdown.
   The user enters findings in the comments field.
   The user clicks the "Complete CMO Review" button.
   Application Logic:
   TicketTransitions validates the selected category and entered findings.
   If the category is invalid or comments are missing:
   An error message is displayed in the UI, prompting the user to correct the input.
   If the category is valid:
   The ProfessionalTicket processes the CMOReport.
   The report quality is calculated.
   If the quality is less than 100 and no comments are provided, a message is displayed in the UI, prompting the user to enter quality comments.
   If the quality is valid, the report quality and time are updated. The ProfessionalTicket status is set to either OPEN_SITE_CALL_REQUIRED or COMPLETED, and the ticket is saved.
6. Completing Site Call (Status: OPEN_SITE_CALL_REQUIRED)
   UI Interaction:
   The user fills in the site call details in the provided fields.
   The user clicks the "Complete Site Call" button.
   Application Logic:
   TicketTransitions validates the site call fields.
   If there are missing fields:
   An error message is displayed in the UI, highlighting the missing fields.
   If all fields are valid:
   The site call details are updated.
   The ProfessionalTicket is saved with the status set to either COMPLETED or OPEN_PIR_REVIEW.
7. Completing Tech ERP Review (Status: TECH_OPEN_ERP_REVIEW)
   UI Interaction:
   The user reviews the technical aspects of the ERP report.
   The user selects a category and enters quality comments.
   The user clicks the "Complete Tech ERP Review" button.
   Application Logic:
   TicketTransitions validates the category and quality.
   If the category is invalid or comments are missing:
   An error message is displayed in the UI.
   If the category and quality are valid:
   The report quality and time are updated.
   The ProfessionalTicket status is set to TECH_COMPLETED.
   The ticket is saved.