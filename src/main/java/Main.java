import models.MainEntityModel;
import models.User;
import models.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static Long userId = 1l;
    private static Long entityId = 1l;
    private static Long entityZip = 1000l;
    private static List<MainEntityModel> mainEntityModelList = new ArrayList();

    public static void main(String[] args) {

        UserEntity userEntity = new UserEntity();
        userEntity.setmId(userId);
        userEntity.setmUsername("User Name " + userId++);

        User user = new User();
        user.setmData(userEntity);

        for (int i = 0; i < 5; i++) {
            MainEntityModel mainEntityModel = new MainEntityModel();
            mainEntityModel.setmId(entityId++);
            mainEntityModel.setmUser(user);
            mainEntityModel.setmZipCode(entityZip++);
            mainEntityModelList.add(mainEntityModel);
        }

        DAO.saveEntityDb(mainEntityModelList);

        System.out.println("saved");

        List<MainEntityModel> savedList = DAO.getEntityDb();

        for (MainEntityModel entity: savedList) {
            System.out.println(entity.getmZipCode() + "\t"
                            + entity.getmUser().getData().getmUsername()
            );
        }
    }
}
