import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class PerformanceCalculator {
  public static void main(String[] args) {
    OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

    while (true) {
      // Calculate CPU usage
      double cpuUsage = osBean.getSystemLoadAverage();

      // Calculate memory usage
      long totalMemory = osBean.getTotalPhysicalMemorySize();
      long freeMemory = osBean.getFreePhysicalMemorySize();
      double memoryUsage = (double) (totalMemory - freeMemory) / totalMemory;

      System.out.println("CPU usage: " + cpuUsage + "%");
      System.out.println("Memory usage: " + memoryUsage + "%");

      try {
        Thread.sleep(1000);  // Wait for 1 second before measuring again
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
