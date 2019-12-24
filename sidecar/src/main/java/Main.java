/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String args[]) throws Exception {

        String current = new java.io.File(".").getCanonicalPath();
        String location = "Test";
        Map<String, String> resultMap = new HashMap<String, String>();
        Map<String, String> EchoAppMap = new HashMap<String, String>();

        resultMap.put("path", current);
        resultMap.put("location", location);

        EchoAppMap.put("zoneId", ZoneId.of("America/Sao_Paulo").toString());
        EchoAppMap.put("delay", "0");
        EchoAppMap.put("period", "20000");

        WriterApp writer = new WriterApp();
        writer.setProps(resultMap);
        writer.call();
        EchoApp echo = new EchoApp();
        echo.setProps(EchoAppMap);
        echo.call();
        ReaderApp reader = new ReaderApp();
        reader.setProps(resultMap);
        reader.call();

    }
}

