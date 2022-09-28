package com.ISS.ISS.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IssService {
        private final IssRepository issRepository;
        private final WebCaller webCaller;

        @Autowired
        public IssService(IssRepository issRepository, WebCaller webCaller) {
                this.issRepository = issRepository;
                this.webCaller = webCaller;
        }

        public List<Iss> getIssList() {
                return issRepository.findAll();
        }

        public Iss getCurrent() {
               Iss currentIss =  webCaller.getNewData();
               issRepository.save(currentIss);
               return currentIss;
        }

        public Iss getIssById(Integer id) {
            Optional<Iss> iss = issRepository.findById(id);
            return iss.orElse(null);
        }
}