package at.htl.guest_register.repository;

import at.htl.guest_register.entity.Visitor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VisitorRepository implements PanacheRepository<Visitor> {
}
