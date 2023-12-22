package com.emotorad.service.repo;

import com.emotorad.service.dto.MessageDto;
import com.emotorad.service.repo.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public interface MessageRepository  extends CrudRepository<Message, String> {
}
