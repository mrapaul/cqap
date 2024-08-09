package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import java.util.*;

import static org.fest.assertions.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoTestConfiguration.class,
        ProfessionalTicketService.class,
        DicomStudyService.class,
        ProfessionalTicketRepository.class,
        DicomStudyRepository.class,
        HL7Service.class,
        InstitutionService.class,
        CounterService.class})
@ActiveProfiles(profiles = "dev")
public class TicketProviderTest extends BaseRepositoryTest
{
    private ProfessionalTicketService theTicketService;
    private DicomStudyService theStudyService;
    private ProfessionalTicketRepository theTicketRepository;
    private DicomStudyRepository theStudyRepository;

    @Before
    public void setUp() throws Exception
    {
        super.setUp();

        AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext();
        theTicketService = myContext.getBean(ProfessionalTicketService.class);
        theStudyService = myContext.getBean(DicomStudyService.class);
        theTicketRepository = myContext.getBean(ProfessionalTicketRepository.class);
        theStudyRepository = myContext.getBean(DicomStudyRepository.class);
    }

    @Test
    public void searchByPriority() throws Exception
    {
        ProfessionalTicket myTicket = new ProfessionalTicket();
        myTicket.setPriority(TicketPriority.RTRT);
        theTicketRepository.save(myTicket);

        TicketQuery myQuery = new TicketQueryBuilder().setTicketPriority(TicketPriority.RTRT.name()).build();
        TicketQueryResults myTickets = theTicketService.findTickets(myQuery);

        assertThat(myTickets.getTickets()).isNotEmpty();
    }

    @Test
    public void searchByName() throws Exception
    {
        DicomStudy myStudy = new DicomStudy();
        myStudy.setPatientName("WATTS^DIONNE");
        theStudyRepository.save(myStudy);
        ProfessionalTicket myTicket = new ProfessionalTicket();
        myTicket.setStudy(myStudy);
        theTicketRepository.save(myTicket);

        TicketQuery myQuery = new TicketQueryBuilder()
                .setPatientFirstName("DIONNE")
                .setPatientLastName("WATTS")
                .build();
        TicketQueryResults myTickets = theTicketService.findTickets(myQuery);

        assertThat(myTickets.getTickets()).isNotEmpty();
    }

    @Test
    public void searchBySubmittedDate() throws Exception
    {
        ProfessionalTicket myTicket = new ProfessionalTicket();
        myTicket.setSubmittedTime(new Date().getTime());
        theTicketRepository.save(myTicket);

        Calendar myCalendar = new GregorianCalendar();
        myCalendar.add(Calendar.DATE, -2);

        TicketQuery myQuery = new TicketQueryBuilder()
                .setDateSubmittedFrom(myCalendar.getTimeInMillis())
                .setDateSubmittedTo(new GregorianCalendar().getTimeInMillis())
                .build();
        TicketQueryResults myTickets = theTicketService.findTickets(myQuery);

        assertThat(myTickets.getTickets()).isNotEmpty();
    }

    @Test
    public void searchByStudyDate() throws Exception
    {
        DicomStudy myStudy = new DicomStudy();
        myStudy.setPatientName("WATTS^DIONNE");
        myStudy.setStudyDate("20130412");
        theStudyRepository.save(myStudy);
        ProfessionalTicket myTicket = new ProfessionalTicket();
        myTicket.setStudy(myStudy);
        theTicketRepository.save(myTicket);

        TicketQuery myQuery = new TicketQueryBuilder()
                .setStudyDate("20130412")
                .build();
        TicketQueryResults myTickets = theTicketService.findTickets(myQuery);

        assertThat(myTickets.getTickets()).hasSize(1);
    }
}


