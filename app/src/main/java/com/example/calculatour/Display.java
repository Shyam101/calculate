package com.example.calculatour;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;




/**
 * A simple {@link Fragment} subclass.
 */
public class Display extends Fragment {

    public Button bns[] = new Button[18];
    public float a[]=new float[25];
    public String string = "";
    public String dd="",te,de="-1";
    private char temp;
    public EditText editText;
    public int cnt=0;
    onMessageListner omg;
    String parts;
    String test="-s".split("-")[0];




    public Display() {
        // Required empty public constructor
    }

    public interface onMessageListner {
        public void msg(String message);
        public void setans(String ans);
    }
    public float eval(String string)
    {
        if(string.length()==0)
            return 0;
        else if(string.contains("+"))
        {
            String par[]=string.split("\\+");
            int i;
            float ans=0;
            for(i=0;i<par.length;i++)
            {
                ans+=eval(par[i]);
            }
            omg.setans(par[0]+"  "+par[1]);
            return ans;
        }
        else if(string.contains("-"))
        {
            String par[]=string.split("-");
            int i;
            float ans=eval(par[0]);
            for(i=1;i<par.length;i++)
            {
                ans-=eval(par[i]);
            }
            return ans;

        }
        /*else if(string.contains("x"))
        {
            String par[]=string.split("-");
            int i;
            float ans=1;
            for(i=0;i<par.length;i++)
            {
                ans*=Float.parseFloat(par[i]);
            }
            return ans;

        }*/
        else if(string.contains("x"))
        {
            String[] parts = string.split("x");
            int i=0;
            te=parts[0];
            for(i=1;i<parts.length-1;i++)
            {
                te+="x"+parts[i];
            }
            float s1= eval(te);
            float s2=eval(parts[parts.length-1]);
            return (s1*s2);

        }
        else if(string.contains("/"))
        {
            String[] parts = string.split("/");
            int i=0;
            te=parts[0];
            for(i=1;i<parts.length-1;i++)
            {
                te+="/"+parts[i];
            }
            float s1= eval(te);
            float s2=eval(parts[parts.length-1]);
            return (s1/s2);
        }
        else
        {
            return Float.parseFloat(string);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);


        bns[0] = view.findViewById(R.id.b0);
        bns[1] = view.findViewById(R.id.b1);
        bns[2] = view.findViewById(R.id.b2);
        bns[3] = view.findViewById(R.id.b3);
        bns[4] = view.findViewById(R.id.b4);
        bns[5] = view.findViewById(R.id.b5);
        bns[6] = view.findViewById(R.id.b6);
        bns[7] = view.findViewById(R.id.b7);
        bns[8] = view.findViewById(R.id.b8);
        bns[9] = view.findViewById(R.id.b9);
        bns[10] = view.findViewById(R.id.bdel);
        bns[11] = view.findViewById(R.id.bsum);
        bns[12] = view.findViewById(R.id.bsub);
        bns[13] = view.findViewById(R.id.bmul);
        bns[14] = view.findViewById(R.id.bdived);
        bns[15] = view.findViewById(R.id.bequal);
        bns[16]=view.findViewById(R.id.bce);
        bns[17]=view.findViewById(R.id.bdot);



        bns[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(de=="0")) {
                    if(de=="-1")
                    {
                        de="0";
                    }
                    else
                        de=de+"0";
                    string = string + "0";
                    omg.msg(string);
                    float ans = eval(string);
                    if (ans == (int) ans) {
                        int jk = (int) ans;
                        dd = Integer.toString(jk);
                    } else {
                        dd = Float.toString(ans);
                    }

                    omg.setans("=" + dd);
                }

            }
        });

        bns[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "1";
                }else if(de=="-1")
                    de="1";
                else
                    de=de+"1";
                string = string + "1";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }
                omg.setans("=" + dd);


            }
        });
        bns[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "2";
                }else if(de=="-1")
                    de="2";
                else
                    de=de+"2";
                string=string+"2";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "3";
                }else if(de=="-1")
                    de="3";
                else
                    de=de+"3";
                string=string+"3";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "4";
                }else if(de=="-1")
                    de="4";
                else
                    de=de+"4";
                string=string+"4";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "5";
                }else if(de=="-1")
                    de="5";
                else
                    de=de+"5";
                string=string+"5";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "1";
                }else if(de=="-1")
                    de="6";
                else
                    de=de+"6";
                string=string+"6";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "7";
                }else if(de=="-1")
                    de="7";
                else
                    de=de+"7";
                string=string+"7";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "8";
                }else if(de=="-1")
                    de="8";
                else
                    de=de+"8";
                string=string+"8";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });bns[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(de=="0") {

                    string = string.substring(0, string.length() - 1);
                    de = "9";
                }else if(de=="-1")
                    de="9";
                else
                    de=de+"9";
                string=string+"9";
                omg.msg(string);
                float ans = eval(string);
                if (ans == (int) ans) {
                    int jk = (int) ans;
                    dd = Integer.toString(jk);
                } else {
                    dd = Float.toString(ans);
                }

                omg.setans("=" + dd);

            }
        });
        bns[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(string.length()>1)
               {
                   test=de;
                   string = string.substring(0, string.length() - 1);
                   omg.msg(string);
                   if(test.length()==1)
                   {
                       de="-1";
                   }
                   else if(test=="-1")
                   {
                       cnt--;
                       de=Float.toString(a[cnt]);
                       float ans = eval(string);

                       if (ans == (int) ans) {
                           int jk = (int) ans;
                           dd = Integer.toString(jk);
                       } else {
                           dd = Float.toString(ans);
                       }
                       omg.setans("=" + dd);
                   }
                   else if(test.length()>1 && test!="-1")
                   {
                       de=de.substring(0,de.length()-1);
                       float ans = eval(string);

                       if (ans == (int) ans) {
                           int jk = (int) ans;
                           dd = Integer.toString(jk);
                       } else {
                           dd = Float.toString(ans);
                       }
                       omg.setans("=" + dd);
                   }
                   }
                   else if(string.length()==1)
                   {
                       string ="";
                       omg.msg(string);
                       dd="";
                       de="-1";
                       omg.setans(dd);
                   }





            }
        });
        bns[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if(string!="") {
                    char c = string.charAt(string.length() - 1);

                    if (!(c >= '0' && c <= '9')) {
                        string = string.substring(0, string.length() - 1);
                    }
                    else
                    {
                        a[cnt]=Float.parseFloat(de);
                        cnt++;
                    }
                    string = string + "+";
                    de="-1";
                    omg.msg(string);
                    omg.setans("="+dd);


                }*/
                if(string!="") {
                    char c=string.charAt(string.length()-1);

                    if(!(c >= '0' && c <= '9'))
                    {
                        string = string.substring(0, string.length() - 1);
                    }
                    else
                    {
                        a[cnt]=Float.parseFloat(de);
                        cnt++;
                    }

                    string = string + "+";
                    de="-1";
                    omg.msg(string);
                    omg.setans("="+dd);
                }

            }

        });bns[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string!="") {
                    char c=string.charAt(string.length()-1);

                    if(!(c >= '0' && c <= '9'))
                    {
                        string = string.substring(0, string.length() - 1);
                    }
                    else
                    {
                        a[cnt]=Float.parseFloat(de);
                        cnt++;
                    }


                    string = string + "-";
                    de="-1";
                    omg.msg(string);
                    omg.setans("="+dd);
                }
                else {
                    string = "-";
                    omg.msg(string);
                }


            }
        });bns[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string!="") {
                    char c=string.charAt(string.length()-1);

                    if(!(c >= '0' && c <= '9'))
                    {
                        string = string.substring(0, string.length() - 1);
                    }
                    else
                    {
                        a[cnt]=Float.parseFloat(de);
                        cnt++;
                    }

                    string = string + "x";
                    de="-1";
                    omg.msg(string);
                    omg.setans("="+dd);
                }

            }
        });
        bns[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string!="") {
                    char c=string.charAt(string.length()-1);

                    if(!(c >= '0' && c <= '9'))
                    {
                        string = string.substring(0, string.length() - 1);
                    }
                    else
                    {
                        a[cnt]=Float.parseFloat(de);
                        cnt++;
                    }

                    string = string + "/";

                    de="-1";
                    omg.msg(string);
                    omg.setans("="+dd);
                }

            }
        });
        bns[15].setOnClickListener(new View.OnClickListener() { //equal
            @Override
            public void onClick(View v) {
                if(string.length()>0) {
                    char c = string.charAt(string.length() - 1);

                if(c >= '0' && c <= '9') {

                   float ans = eval(string);

                       if (ans == (int) ans) {
                           int jk = (int) ans;
                           dd = Integer.toString(jk);
                       } else {
                           dd = Float.toString(ans);
                       }
                      // omg.setans("=" + dd);
                    
                       omg.msg(dd);
                    omg.setans(" ");
                    
                       string = dd;
                       de=dd;
                       dd = "";

                }
                }
            }
        });
        bns[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string ="";
                omg.msg(string);
                dd="";
                de="-1";
                omg.setans(dd);

            }
        });
        bns[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!de.contains(".")) {
                    if(de=="-1")
                    {
                        string+="0.";
                        de="0.";
                    }
                    else {
                        string = string + ".";
                        de = de + ".";
                    }
                    omg.msg(string);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            omg = (onMessageListner) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must do this");
        }


    }
}
