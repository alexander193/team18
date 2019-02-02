package sut.se.g18;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import sut.se.g18.Entity.CompanyEntity;
import sut.se.g18.Entity.LearnedEntity;
import sut.se.g18.Entity.MaidRegisterEntity;
import sut.se.g18.Repository.CompanyRepository;
import sut.se.g18.Repository.LearnedRepository;
import sut.se.g18.Repository.MaidRegisterRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LearnedTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LearnedRepository learnedRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MaidRegisterRepository maidRegisterRepository;

    private Validator validator;

    private CompanyEntity company1;

    private MaidRegisterEntity maid;

    private SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");



    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        company1 = companyRepository.findBycompanyName("พีกาซัส");
    }

    @Test
    public void testSuccess() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setCheckObject(true);
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println(company1);
        System.out.println("\n\n\n\n\n\n\n");

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST NULL DETAIL
    @Test
    public void testNullDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail(null);
        L.setCompany(company1);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST MIN SIZE DETAIL
    @Test
    public void testMinSizeDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์");
        L.setCompany(company1);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2); //ผิด Pattern ด้วย
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST MAX SIZE DETAIL
    @Test
    public void testMaxSizeDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนแต่งหน้า นั่งสมาธิ ดำน้ำ ปลูกปะการัง ทำอาหาร นวดสปา ปลูกป่า ดำนา ดูดิสนีย์ออนไอซ์ แรลลี่ตีกอล์ฟ ล่องเรือ ส่องสัตว์ ช๊อปปิ้ง ดูงิ้ว ดูละครเวที ดูคอนเสิร์ต " +
                "ดินเนอร์ ทำขนม จัดดอกไม้ เที่ยวตลาดน้ำ เรียนถ่ายรูป ดูกายกรรม ชมเมืองเก่า เข้าสัมมนา ทัวร์ธรรมมะ เรียนเต้นแล้วก็ร้องเพลง");
        L.setCompany(company1);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // TEST INVALID PATTERN DETAIL
    @Test
    public void testInvalidPatternDetail() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์เรียนแต่งหน้า นั่งสมาธิ ดำน้ำ ปลูกปะการัง");
        L.setCompany(company1);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2019 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //TEST INVALID DATE
    @Test
    public void testInvalidDate() {
        LearnedEntity L = new LearnedEntity();
        L.setDetail("คอร์สเรียนตัดหญ้า");
        L.setCompany(company1);
        L.setCheckObject(true);

        try {
            L.setDateLearned(formatter5.parse("Thu, Oct 18 2018 00:00:00"));
            entityManager.persist(L);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
