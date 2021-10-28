package programers.level1;

public class new_id {
    public static void main(String[] args) {
        String new_id = "{}[]";

        // .~!@#$%^&*()=+[{]}:?,<>/ 는 빈문자로 교체 -> 정규식 에러
        new_id = new_id.toLowerCase()
                .replaceAll("[^-_.\\w]", "") // []안에 ^있으면 []안에 있는게 아닌것을 찾음
                .replaceAll("[.]{2,}", ".") // .이 두개 이상인 것
                .replaceAll("^[.]|[.]$", ""); // .으로 시작 | .으로 끝나는 것

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
        }

        if (new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() <= 2) {
            StringBuffer sb = new StringBuffer(new_id);
            char end = new_id.charAt(new_id.length() - 1);

            while (new_id.length() < 3) {
                new_id = sb.append(end).toString();
            }
        }

        System.out.println(new_id);
    }
}
