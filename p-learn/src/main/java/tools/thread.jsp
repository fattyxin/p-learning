<%@ page import="java.util.Map" %>
<html>
<head>
    <title>threadInfo</title>
</head>
<body>
<pre>
    <%
        for (Map.Entry<Thread, StackTraceElement[]> stackTrance : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) stackTrance.getKey();
            StackTraceElement[] stackTraceElements = stackTrance.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            out.print("\n Thread:" + thread.getName() + "\n");
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                out.print("\t" + stackTraceElement + "\n");
            }
        }

    %>
</pre>
</body>
</html>