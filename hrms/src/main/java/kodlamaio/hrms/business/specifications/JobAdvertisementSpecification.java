package kodlamaio.hrms.business.specifications;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.criteria.Predicate;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;


/*
 * https://www.baeldung.com/rest-api-search-language-spring-data-specifications
 * 
 * Baeldung Kaynağından Yararlanıldı
 */

public class JobAdvertisementSpecification {

    public static Specification<JobAdvertisement> jobAdsFilter(JobAdvertisement jobAd){
    	
        return new Specification<JobAdvertisement>() {
            @Override
            public Predicate toPredicate(Root<JobAdvertisement> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();

                if(jobAd.getCity() != null  && jobAd.getCity().getId() != 0){
                    final Predicate cityPredicate = root.get("city").get("id").in(jobAd.getCity().getId());
                    predicates.add(cityPredicate);
                }

                if(jobAd.getJobtitle() != null && jobAd.getJobtitle().getId() != 0){
                    final Predicate positionPredicate = root.get("jobtitle").get("id").in(jobAd.getJobtitle().getId());
                    predicates.add(positionPredicate);
                }

                if(jobAd.getWorkHour() != null && jobAd.getWorkHour().getId() != 0){
                    final Predicate workingTimePredicate = root.get("workHour").get("id").in(jobAd.getWorkHour().getId());
                    predicates.add(workingTimePredicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}