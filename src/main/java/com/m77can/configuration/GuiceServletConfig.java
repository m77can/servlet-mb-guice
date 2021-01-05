package com.m77can.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.m77can.controller.UserServlet;
import com.m77can.entity.User;
import com.m77can.mapper.UserMapper;
import com.m77can.service.UserService;
import com.m77can.service.impl.UserServiceImpl;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import javax.servlet.annotation.WebListener;
import java.util.Properties;

@WebListener
public class GuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(createMyBatisModule(), createServletModule());
    }


    private Module createMyBatisModule() {
        return new MyBatisModule() {
            @Override
            protected void initialize() {
                environmentId("production");
                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);

                addSimpleAlias(User.class);
                addMapperClass(UserMapper.class);

                Names.bindProperties(binder(), createProperties());
            }
        };
    }

    private Module createServletModule() {
        return new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/users").with(UserServlet.class);

                bind(UserService.class).to(UserServiceImpl.class);

            }
        };
    }

    private Properties createProperties() {
        Properties properties = new Properties();

        properties.put("JDBC.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("JDBC.url", "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true");
        properties.put("JDBC.username", "root");
        properties.put("JDBC.password", "root");

        return properties;
    }
}
