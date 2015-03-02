package com.demo.task.service.test;

import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Assert;
import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

@RunWith( HttpJUnitRunner.class )
public class RESTServiceTest {
	
	public static final String URL = "http://localhost:9090/taskManager/";
	
	@Rule
	public Destination destination = new Destination( URL );
	
	@Context
	private Response response;
	
	@HttpTest(method=Method.GET,path="/tasks")
	public void testShowAllTasks() throws Exception {
		Assert.assertOk( response );
	}
	
	@HttpTest(method=Method.GET,path="/tasks/2/delete")
	public void testDelete() throws Exception {
		Assert.assertOk( response );
	}
	
	@HttpTest(method=Method.GET,path="/tasks/1")
	public void testEditTask() throws Exception {
		Assert.assertOk( response );
	}
	
	@HttpTest(method=Method.GET,path="/tasks/new")
	public void testCreate() {
		Assert.assertOk( response );
	}
	
	@HttpTest(method=Method.POST,path="/tasks/new")
	public void testAddRequest() {
		Assert.assertOk( response );
	}
	
}
