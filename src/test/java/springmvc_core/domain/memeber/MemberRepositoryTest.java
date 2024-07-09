package springmvc_core.domain.memeber;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {

        Member member = new Member("hello", 20);
        Member saved = memberRepository.save(member);
        Member byId = memberRepository.findById(saved.getId());
        Assertions.assertThat(byId).isEqualTo(saved);
    }

    @Test
    void findById() {
        Member member1 = new Member("Member1", 20);
        Member member2 = new Member("Member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> all = memberRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all.get(0)).isEqualTo(member1);
        assertThat(all.get(1)).isEqualTo(member2);
    }

    @Test
    void findAll() {
    }

    @Test
    void clearStore() {
    }

    @Test
    void getInstance() {
    }
}