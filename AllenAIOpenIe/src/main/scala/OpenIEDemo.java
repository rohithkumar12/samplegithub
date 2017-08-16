/**
 * Created by rohithkumar on 7/16/17.
 */

public class OpenIEDemo{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("---Started---");

        OpenIE openIE = new OpenIE(new ClearParser(new ClearPostagger(new ClearTokenizer())), new ClearSrl(), false, false);

        Seq<Instance> extractions = openIE.extract("U.S. president Barack Obama gave his inaugural address on January 20, 2013.");

        List<Instance> list_extractions = JavaConversions.seqAsJavaList(extractions);
        for(Instance instance : list_extractions) {
            StringBuilder sb = new StringBuilder();

            sb.append(instance.confidence())
                    .append('\t')
                    .append(instance.extr().context())
                    .append('\t')
                    .append(instance.extr().arg1().text())
                    .append('\t')
                    .append(instance.extr().rel().text())
                    .append('\t');

            List<Argument> list_arg2s = JavaConversions.seqAsJavaList(instance.extr().arg2s());
            for(Argument argument : list_arg2s) {
                sb.append(argument.text()).append("; ");
            }

            System.out.println(sb.toString());
        }
    }

}

