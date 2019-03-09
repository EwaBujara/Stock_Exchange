package pl.stock.app;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.stock.entity.Stock;
import javax.transaction.Transactional;


@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
//        Privilege adminPrivilege = createPrivilegeIfNotFound("ADMIN_PRIVILEGE");
//        Privilege teacherPrivilege = createPrivilegeIfNotFound("TEACHER_PRIVILEGE");
//        Privilege studentPrivilege = createPrivilegeIfNotFound("STUDENT_PRIVILEGE");
//
//        Role adminRole = createRoleIfNotFound("Admin", Arrays.asList(adminPrivilege));
//        Role teacherRole = createRoleIfNotFound("Teacher", Arrays.asList(teacherPrivilege));
//        Role userRole = createRoleIfNotFound("User", Arrays.asList(studentPrivilege));
//        Group startGroup = createGroupIfNotFound("Bucket");
//
//        User user = new User();
//        user.setUsername("Admin");
//        user.setPassword("Password");
//        user.setEmail("admin@admin.com");
//        user.setRoles(Arrays.asList(adminRole, teacherRole, userRole));
//        user.setEnabled(true);
//        user.setGroups(Arrays.asList(startGroup));
//        userService.save(user);

        alreadySetup = true;
    }

    @Transactional
    public Stock createStockIfNotFound(String name) {

//        Privilege privilege = privilegeRepository.findByName(name);
//        if (privilege == null) {
//            privilege = new Privilege();
//            privilege.setName(name);
//            privilegeRepository.save(privilege);
//        }
//        return privilege;
        Stock stock = new Stock();
        return  stock;
    }




}
