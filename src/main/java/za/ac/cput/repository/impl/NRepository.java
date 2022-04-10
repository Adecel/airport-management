package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.entity.NoticeBoard;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface NRepository extends IRepository<NoticeBoard, String> {

    public Set<NoticeBoard> getAll();
}

