package dialect;

import org.hibernate.boot.model.TypeContributions;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

import javax.imageio.spi.ServiceRegistry;

public class MyH2Dialect extends H2Dialect {
//    public MyH2Dialect(){
//        registerFunction("group_concat",new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
//
//    }
//    @Override
//    public void contributeTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
//        super.contributeTypes(typeContributions, serviceRegistry);
//        typeContributions.contributeSqlFunction("group_concat",
//                new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
//    }
}
