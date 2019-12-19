//package com.uestc.miaoshi.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 拦截器
// *
// * 和过滤器不同的是拦截器可以知道当前的用户请求的是哪个控制器的哪个方法
// * 单单使用@Component是不能让拦截器起作用的，还需要额外的配置
// * （在WebConfig里面配置 1、继承WebMvcConfigurerAdapter  2、在addInterceptors里面添加拦截器）
// *
// * 其实我们知道了是哪个控制器的哪个方法被调用也是没用的，因为我们不知道用户请求过来的参数是什么　<br> * 如果需要知道请求参数的话需要用到切片Aspect（也就是Spring AOP）
// */
//@Component
//public class DemoInteceptor implements HandlerInterceptor {
//
//    /**
//     * 控制器方法被调用之前
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @param o
//     * @return 返回false就不会调用后面的方法了，
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//
//        System.out.println("preHandle");
//
//        //获取控制器的名字
//        System.out.println(((HandlerMethod) o).getBean().getClass().getName());
//        //获取方法名
//        System.out.println(((HandlerMethod) o).getMethod().getName());
//
//        return true;
//    }
//
//    /**
//     * 控制器的方法处理之后 如果出现异常则不调用
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @param o
//     * @param modelAndView
//     * @throws Exception
//     */
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//        String result = (String) modelAndView.getModel().get("result");
//        System.out.println(result);
//        System.out.println("postHandle");
//
//
//    }
//
//    /**
//     *  出不出现异常都会调用
//     * @param httpServletRequest
//     * @param httpServletResponse
//     * @param o
//     * @param e
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//        System.out.println("afterCompletion");
//
//        System.out.println("ex is "+e);
//    }
//}