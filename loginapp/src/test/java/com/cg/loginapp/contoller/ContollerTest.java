package com.cg.loginapp.contoller;

/**
 * author --> Sai Vineeth Neeli 
 */


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.service.AdminServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminContoller.class)
public class ContollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminServices Service;

    @Test
    public void testGetUsers() throws Exception{
        String URI = "/admin/getAllUser";
         
        User u = new User();
	    u.setEmailId("vin@gmail.com");
		u.setUserType("doctor");
		u.setFirstName("sai");
		u.setLastName("vinnu");
		u.setPhoneNo("985623147");
		u.setPassword("sai#2123Saa");
		u.setDob("12/05/2000");
		u.setSecurityQue("whats your birth place");
		u.setSecurityAns("jgl");

        User u1 = new User();
	    u1.setEmailId("vi22n@gmail.com");
		u1.setUserType("doctors");
		u1.setFirstName("saini");
		u1.setLastName("vinnu");
		u1.setPhoneNo("985623157");
		u1.setPassword("sai#2123Sa");
		u1.setDob("12/05/2001");
		u1.setSecurityQue("whats your birth place");
		u1.setSecurityAns("jglj");

        List<User> UserList = new ArrayList<>();
        UserList.add(u);
        UserList.add(u1);

        String jsonInput = this.converttoJson(UserList);

        Mockito.when(Service.listAllUsers()).thenReturn(UserList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
    }
    
    private String converttoJson(Object user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }
}

