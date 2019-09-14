package listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoaderListener implements ServletContextListener {
//上下文初始化方法
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 读取web.xml 中的全局参数
        String contexConfigLocation = servletContext.getInitParameter("contextConfigLocation");


        ApplicationContext app = new ClassPathXmlApplicationContext(contexConfigLocation);
        servletContext.setAttribute("app",app);
        System.out.println("spring容器创建完毕....");


    }

    // 上下文销毁方法
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}
