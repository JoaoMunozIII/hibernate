import models.MainEntityModel;
import models.User;
import models.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Hibernate {

    private static SessionFactory sessionFactory = null;
    private static String dbPath = "D:" + File.separator + "temp.db";

    public static SessionFactory getSessionFactory() {
        System.out.println("factory " + sessionFactory);
        if (sessionFactory == null) {
            Configuration cfg = new Configuration()
                    .setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC")
                    .setProperty("hibernate.dialect", "dialect.SQLiteDialect")
                    .setProperty("hibernate.connection.pool_size", "1")
                    .setProperty("hibernate.connection.url", "jdbc:sqlite:" + dbPath)
                    .setProperty("hibernate.connection.username", "pass")
                    .setProperty("hibernate.connection.password", "pass")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("hibernate.format_sql", "false")
                    .setProperty("hibernate.hbm2ddl.auto", "create-drop")
                    .setProperty("hibernate.use_sql_comments", "false")
                    .addAnnotatedClass(MainEntityModel.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(UserEntity.class);
            sessionFactory = cfg.buildSessionFactory();
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }

//______________________________________________
//    private static StandardServiceRegistry registry;
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                StandardServiceRegistryBuilder registryBuilder =
//                        new StandardServiceRegistryBuilder();
//
//                Map<String, Object> settings = new HashMap<>();
//                settings.put(Environment.DRIVER, "org.sqlite.JDBC");
//                settings.put(Environment.URL,"jdbc:sqlite:" + dbPath);
//                settings.put(Environment.USER, "nimda");
//                settings.put(Environment.PASS, "nimda");
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//                settings.put(Environment.POOL_SIZE, "1");
//                settings.put(Environment.DIALECT, "dialect.SQLiteDialect");
//                settings.put(Environment.SHOW_SQL, true);
//
//                settings.put("hibernate.search.default.directory_provider", "filesystem");
//                settings.put("hibernate.search.default.indexBase", "C:/hibernate/lucence/indexes");
//                settings.put("hibernate.search.default.indexwriter.infostream", true);
//
//                registryBuilder.applySettings(settings);
//
//                registry = registryBuilder.build();
//                MetadataSources sources = new MetadataSources(registry)
//                        .addAnnotatedClass(MainEntityModel.class)
//                        .addAnnotatedClass(User.class)
//                        .addAnnotatedClass(UserEntity.class);
//
//                Metadata metadata = sources.getMetadataBuilder().build();
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//            } catch (Exception e) {
//                if (registry != null) {
//                    StandardServiceRegistryBuilder.destroy(registry);
//                }
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }

//    private final static Configuration config = new Configuration()
//            .setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC")
//            .setProperty("hibernate.dialect", "dialect.SQLiteDialect")
//            .setProperty("dialect", "bom.hibernate.utils.SQLiteDialect")
//            .setProperty("hibernate.connection.pool_size", "10")
//            .setProperty("hibernate.connection.url", "jdbc:sqlite:" + dbPath)
//            .setProperty("hibernate.connection.username", "nimda")
//            .setProperty("hibernate.connection.password", "nimda")
//            .setProperty("hibernate.show_sql", "true")
//            .setProperty("hibernate.format_sql", "false")
//            .setProperty("hibernate.generate_statistics", "false")
//            .setProperty("hbm2ddl.auto", "create-drop")
//            .setProperty("hibernate.hbm2ddl.auto", "update")
//            .setProperty("hibernate.use_sql_comments", "false")
//            .addAnnotatedClass(User.class)
//            .addAnnotatedClass(UserEntity.class)
//            .addAnnotatedClass(MainEntityModel.class);
//    static SessionFactory sf;
//    static Session session;
//
//    public static Session getSessionFactory() {
//        if (session == null) {
//            sf = config.buildSessionFactory();
//            session = sf.openSession();
//        }
//        return session;
//    }
}
