package click.tomasz;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;

import javax.servlet.ServletException;
import java.io.File;
import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) throws ServletException, SQLException {

		String webappDirLocation = "C:\\Users\\Tomek\\IdeaProjects\\action\\action-rest\\target\\action-rest-1.0-SNAPSHOT.war";
		String webPort = "8080";

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(Integer.valueOf(webPort));

		StandardContext ctx =
				(StandardContext) tomcat.addWebapp("/action-rest", new File(webappDirLocation).getAbsolutePath());
		System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

		ContextResource resource = new ContextResource();
		resource.setName("jdbc/db");
		resource.setAuth("Container");
		resource.setType("javax.sql.DataSource");
		resource.setScope("Sharable");
		resource.setProperty("driverClassName",	"org.h2.Driver");
		resource.setProperty("url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		resource.setProperty("user", "sa");
		resource.setProperty("password", "sa");

		ctx.getNamingResources().addResource(resource);

//		File additionWebInfClasses = new File("target/classes");
//		WebResourceRoot resources = new StandardRoot(ctx);
//		resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
//				additionWebInfClasses.getAbsolutePath(), "/"));
//		ctx.setResources(resources);

		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		tomcat.getServer().await();
	}
}
