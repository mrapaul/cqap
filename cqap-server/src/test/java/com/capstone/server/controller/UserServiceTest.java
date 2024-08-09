package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.junit.*;
import org.mockito.*;

import java.util.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceTest
{
    @Mock private UserRepository theUserRepository;
    @Mock private User theUser;
    private UserService theUserService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        theUserService = new UserService(theUserRepository);
    }

    @Test
    public void shouldSaveUser()
    {
        theUserService.createOrUpdate(theUser);

        verify(theUserRepository).save(theUser);
    }

    @Test
    public void shouldDeleteUser()
    {
        theUserService.delete(theUser);

        verify(theUserRepository).delete(theUser);
    }

    @Test
    public void shouldQueryRepositoryWithUsername()
    {
        when(theUserRepository.findByTheUsername(anyString())).thenReturn(theUser);
        String myUsername = "name";
        User myUser = theUserService.findByUsername(myUsername);

        assertThat(myUser).isSameAs(theUser);
    }

    @Test
    public void shouldQueryRepositoryWithRole()
    {
        when(theUserRepository.findByTheRole(Role.QAD)).thenReturn(Arrays.asList(theUser));

        Users myUsersByRole = theUserService.findUsersByRole(Role.QAD);

        assertThat(myUsersByRole.getUsers()).containsExactly(theUser);

        myUsersByRole = theUserService.findUsersByRole(Role.CMO);

        assertThat(myUsersByRole.getUsers()).isEmpty();
    }

    @Test
    public void shouldFindAllUsers()
    {
        when(theUserRepository.findAll()).thenReturn(Arrays.asList(theUser));

        Users myResult = theUserService.findAllUsers();
        verify(theUserRepository).findAll();

        assertThat(myResult.getUsers()).containsExactly(theUser);
    }
}
