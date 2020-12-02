
@SpringBootApplication        // 启动类
   @SpringbootConfiguration   // 配置类
        @Configuration        // 配置类
            @Component        // Spring中的一个组件
   @EnableAutoConfiguration   // 开启自动配置功能
        @AutoConfigurationPackage    // 这个注解是自动配置包，主要是使用的@Import来给Spring容器中导入一个组件 ，这里导入的是Registrar.class。
                                     // 说白了就是将主配置类（即@SpringBootApplication标注的类）的所在包及子包里面所有组件扫描加载到Spring容器。
        @Import({AutoConfigurationImportSelector.class})    //@Import注解就是给Spring容器中导入一些组件，这里传入了一个组件的选择器:AutoConfigurationImportSelector           
              // getCandidateConfigurations方法
              protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
                      // loadFactoryNames扫描所有具有META-INF/spring.factories的jar包
                      List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
                      Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
                      return configurations;
              }              
              // Spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，
              将这些值作为自动配置类导入到容器中，自动配置类就生效，帮我们进行自动配置工作。以前我们需要自己配置的东西，自动配置类都帮我们完成了。
              // 我们在回到getAutoConfigurationEntry这个方法当执行完getCandidateConfigurations这个方法的时候我们可以看到此时总共加载了127个自动配置类。
              // 这些类难道都要加载进去吗？springboot还是没有那么傻的，它提倡的话是按需加载。               
                 它会去掉重复的类
                 过滤掉我们配置了exclude注解的类下面配置就会过滤掉RestTemplateAutoConfiguration这个类
              // 这些注解都组合了@Conditional注解，只是使用了不同的条件组合最后为true时才会去实例化需要实例化的类，否则忽略过滤掉。
                 我们在回到代码可以看到经过了条件判断过滤后我们剩下符合条件的自动配置类只剩23个了。其他的都是因为不满足条件注解而被过滤了。
   