package tomasz.click;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class Runner {
	public static void main(String[] args) throws ServletException {
		String webappDirLocation = "C:\\Users\\Tomek\\IdeaProjects\\action\\action-rest\\target\\action-rest-1.0-SNAPSHOT.war";
		String webPort = "8080";

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(Integer.valueOf(webPort));

		StandardContext ctx =
				(StandardContext) tomcat.addWebapp("/action", new File(webappDirLocation).getAbsolutePath());
		System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

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
