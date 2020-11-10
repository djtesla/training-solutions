package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();


    public List<Member> getMembers() {
        return members;
          }

    @Override
    public String toString() {
        return members.toString();
    }


    public void addMember(String memberName) {
        members.add(new Member(memberName));
    }


    public void connect(String name, String otherName) {

        Member memberFirst = findByName(name);

        for (Member memberSecond : memberFirst.getConnections()) {



                if (memberSecond.getName().equals(otherName)) {

                    memberFirst.connectMember(findByName(otherName));
                }
            }
        }



    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
                }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {

        List<String> connectionsList = new ArrayList<>();

        for (Member member : members) {

            for (Member member2 : member.getConnections()) {

                if (member2.getConnections().contains(member)) {

                    connectionsList.add(member.getName() + " - " + member2.getName());
                }
            }

        }
        return connectionsList;
                }
        }










