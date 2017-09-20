//package hfutonline.filter;
//
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//import java.util.logging.Filter;
//
///**
// * Created by lenovo on 2017/9/16.
// */
//public class userFilter implements Filter{
//    @Order(1)
////重点
//    @WebFilter(filterName = "testFilter1", urlPatterns = "/*")
//    public class TestFilterFirst implements Filter {
//        @Override
//        public void init(FilterConfig filterConfig) throws ServletException {
//
//        }
//
//        @Override
//        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//                throws IOException, ServletException {
//            System.out.println("TestFilter1");
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//
//        @Override
//        public void destroy() {
//
//        }
//    }
//
//}
