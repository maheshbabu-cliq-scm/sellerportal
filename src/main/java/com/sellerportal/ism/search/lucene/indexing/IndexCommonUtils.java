/**
 * 
 */
package com.sellerportal.ism.search.lucene.indexing;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sellerportal.ism.search.lucene.indexing.IndexConfiguration.ConfigParam;





/**
 * @author Binod Kumar
 *
 */
public class IndexCommonUtils {
	public static boolean isCacheInitialized = false;

	public static class ProgressThread extends Thread {
		private int interval = 10; // each 10 seconds it will update
		private long start = System.currentTimeMillis();
		private NumberFormat nb = NumberFormat.getInstance();
		private long lastPrintTime = System.currentTimeMillis();
		private SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MMM-yy hh:mm:ss");
		
		private long printGap = 500;
	
		int totalCount = 0;
	
		public ProgressThread(int _interval, int totalIndexCount) {
			interval = _interval;
			this.totalCount = totalIndexCount;
			nb.setMaximumFractionDigits(2);
			nb.setMinimumFractionDigits(2);
		}
	
		public void run() {
			while (!IndexHelper.abort.get()) {
				try {
					Thread.sleep(interval * 1000);
				} catch (Exception e) {
				}
				
				if((System.currentTimeMillis()-lastPrintTime)<printGap) {
					continue;
				}
				lastPrintTime = System.currentTimeMillis();
				long totalDone = (IndexHelper.indexed.get() + IndexHelper.discarded.get());
				double percentage =  (( totalDone* 100.00) / (totalCount*1.0));
				
				long elapsedMillis = (System.currentTimeMillis() - start);
				String fmtPercentage = nb.format(percentage);
	
				if (percentage <= 100){
					IndexHelper.LOGGER.info("["+DATE_FORMATTER.format(new Date())+"] PROGRESS [ "+ totalDone+ "/" + totalCount+ " ("+fmtPercentage+"%)  TIME = "+(elapsedMillis)/1000+" sec, TPS = "+(int) (totalDone*1000/elapsedMillis) +" ]   :: INDEXED = "+ IndexHelper.indexed+ ", DISCARDED = " + IndexHelper.discarded + " ");
				}else {
					System.out.println(" PROGRESS THREAD FINISHED  "+fmtPercentage);
					break;
				}
			}
			System.out.println("PROGRESS THREAD FINISHED");
		}
	}

	static class CategoryRecord {
		private Long id;
		private String name;
		private CategoryRecord []  parents = new CategoryRecord[0];
		private int level;
		private String cmtcode;
		
		/**
		 * @return Returns the id.
		 */
		public Long getId() {
			return id;
		}
	
		/**
		 * @param id
		 *            The id to set.
		 */
		public void setId(Long id) {
			this.id = id;
		}
	
		/**
		 * @return Returns the name.
		 */
		public String getName() {
			return name;
		}
	
		/**
		 * @param name
		 *            The name to set.
		 */
		public void setName(String name) {
			this.name = name;
		}
	
		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		/**
		 * @param id
		 * @param name
		 */
		public CategoryRecord(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
	
		public CategoryRecord[] getParents() {
			return parents;
		}

		public void setParents(CategoryRecord[] parents) {
			this.parents = parents;
		}
		
		public String getCmtcode() {
			return cmtcode;
		}

		public void setCmtcode(String cmtcode) {
			this.cmtcode = cmtcode;
		}

		

		public boolean equals(Object obj) {
			if (obj != null && obj instanceof CategoryRecord) {
				CategoryRecord other = (CategoryRecord) obj;
				if (other.getId().equals(id))
					return true;
			}
			return false;
		}

		@Override
		public int hashCode() {			
			return super.hashCode();
		}
		
		
	}

	public static long getFreeMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.freeMemory();
	}

	public static long printMemoryInfo(String msg) {
		Runtime runtime = Runtime.getRuntime();
		System.err.println(Thread.currentThread().getName() + " -> " + msg
				+ " -> Memory Used ["
				+ (runtime.totalMemory() - runtime.freeMemory()) / 1000
				+ " KB]");
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		return usedMemory;
	}

	static void _runGC() {
		long usedMem1 = IndexCommonUtils.usedMemory(), usedMem2 = Long.MAX_VALUE;
		for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++i) {
			IndexCommonUtils.s_runtime.runFinalization();
			IndexCommonUtils.s_runtime.gc();
			Thread.yield();
			usedMem2 = usedMem1;
			usedMem1 = IndexCommonUtils.usedMemory();
		}
	}

	public static void runGC() {
		for (int r = 0; r < 10; ++r) {
			try {
				_runGC();
			} catch (Exception e) {
			}
		}
	}

	public static long usedMemory() {
		return IndexCommonUtils.s_runtime.totalMemory() - IndexCommonUtils.s_runtime.freeMemory();
	}

	public static final Runtime s_runtime = Runtime.getRuntime();

	/**
	 * Deletes the index directory from physical file system
	 * 
	 */
	public static void removeIndexDirectory(String directory) {
		File file = new File(directory);
		File[] files = file.listFiles();
		for (int i = 0; files != null && i < files.length; i++) {
			if (files[i].isFile())
				files[i].delete();
		}
	
		boolean b = file.delete();
		if (b == false)
			IndexHelper.LOGGER.error("Could not delete the [" + directory + "]");
	}

	/**
	 * Build the cache for indexing
	 *
	 */

	/**
	 * @param string
	 * @param total
	 * @param time
	 */
	public static void printSummary() {
		// Create summary report
		
		long time = (System.currentTimeMillis() - IndexHelper.start.getTime()); // Start
		// time
		try {
			IndexHelper.LOGGER.info("--------------------------------------------------------------------");
			IndexHelper.LOGGER.info("					Indexing Summary 								");
			IndexHelper.LOGGER.info("--------------------------------------------------------------------");
			IndexHelper.LOGGER.info("* TOTAL Documents : [" + IndexHelper.total + "] ");
			IndexHelper.LOGGER.info("*  - INDEXED :     [" + IndexHelper.indexed + "]");
			IndexHelper.LOGGER.info("*  - DISCARDED :   [" + IndexHelper.discarded + "]");
			IndexHelper.LOGGER.info("*  - MAX TIME      [" + IndexHelper.longestIndexTime + "] ms");
			IndexHelper.LOGGER.info("*  - AVG. TIME     [" + (time / IndexHelper.total) + "] ms");
			IndexHelper.LOGGER.info("*  - TOTAL TIME    [" + time + "] ms \n");
			//IndexHelper.LOGGER.info("*  - INDEX DIRECTORY [" + new File(dir).getAbsolutePath() + "]");
			IndexHelper.LOGGER.info("--------------------------------------------------------------------");
	
		} catch (Exception e) {
			// LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		} finally {
			
		}
	
	}

	/*public static void createWriter(String directory, boolean create,
			int mergeFactor) throws IOException {
		
		 Directory fsDirectory = FSDirectory.open(new File(directory));
		 
		*//**
		 * //autoCommit = false for fast indexing Use autoCommit=false when you
		 * open your IndexWriter In Lucene 2.3 there are substantial
		 * optimizations for Documents that use stored fields and term vectors,
		 * to save merging of these very large index files. You should see the
		 * best gains by using autoCommit=false for a single long-running
		 * session of IndexWriter. Note however that searchers will not see any
		 * of the changes flushed by this IndexWriter until it is closed; if
		 * that is important you should stick with autoCommit=true instead or
		 * periodically close and re-open the writer.
		 *//*
		
		//IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_2, new StandardAnalyzer(Version.LUCENE_4_10_2));
		  IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_2, new StandardAnalyzer());
		
		
		
		 LogByteSizeMergePolicy chooses segments to merge based on their size.  The Lucene 2.2 default, LogDocMergePolicy chose when
		 to merge based on number of documents 
		 Other implementations of MergePolicy must have a no-argument constructor
		<mergePolicy>org.apache.lucene.index.LogByteSizeMergePolicy</mergePolicy>
		 
		try
		{
			String mergePolicyClass = IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_MERGE_POLICY_CLASS,"org.apache.lucene.index.LogByteSizeMergePolicy");
			MergePolicy mergePolicy = (MergePolicy) Class.forName(mergePolicyClass).newInstance();
			config.setMergePolicy(mergePolicy);
		}catch(Exception e) {
			LOGGER.error(e.getStackTrace());
		}
		
		
		IndexWriter writer = new IndexWriter(fsDirectory,config);
		
		// IndexWriter writer = new IndexWriter(directory, new
		// StandardAnalyzer(),create);
		// mergeFactory should be always > 5000 for indexing
		//((TieredMergePolicy) IndexHelper.writer.getConfig().getMergePolicy()).setMergeFactor(mergeFactor);// mergeFactor = mergeFactor;
		((LogMergePolicy) config.getMergePolicy()).setMergeFactor(mergeFactor);
	
		// You need to first set [WWW] maxBufferedDocs large enough to prevent
		// the writer from flushing based on document count. However, don't set
		// it too large otherwise you may hit [WWW] LUCENE-845. Somewhere around
		// 2-3X your "typical" flush count should be OK.
		int maxBufferedDocs = Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_MAX_BUFFEREDDOCS, "5000"));
		config.setMaxBufferedDocs(maxBufferedDocs);
		
	
		int ramBufferSize = Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_RAM_BUFFERSIZE_MB, "256"));
		config.setRAMBufferSizeMB(ramBufferSize);
		
		String useCompoundFile = IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_USE_COMPOUND_FILE,"false");
		if(useCompoundFile.equalsIgnoreCase("true"))
			config.setUseCompoundFile(true);
		else
			config.setUseCompoundFile(false);
		
		try {
			String mergeSchedulerClass = IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_MERGE_SCHEDULER_CLASS,"org.apache.lucene.index.ConcurrentMergeScheduler");
			MergeScheduler mergeScheduler = (MergeScheduler) Class.forName(mergeSchedulerClass).newInstance();
			config.setMergeScheduler(mergeScheduler);
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
		} 
		 writer.close();
		//writer.setMergePolicy(MergePolicy);
	}
	
	public static void createWriter(String directory)
			throws IOException {
		int mergeFactor = Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_MERGE_FACTOR,
				"5000"));
		createWriter(directory, true, mergeFactor);
	}*/

	public static int getWorkSize() {
		return Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_WORKER_SIZE, "10"));
	}

	public static int getThreads() {
		return Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_WORKER_THREADS, "5"));
	}
	
	public static int getMergeFactor() {
		return Integer.parseInt(IndexConfiguration.getConfiguration(ConfigParam.KEY_WRITER_MERGE_FACTOR, "2000"));
	}

	
	public static String toCsv(Object [] ar)
	{
		StringBuffer buffer = new StringBuffer();
		if(ar != null && ar.length > 0)
		{
			int k=0;
			for (int i = 0; i < ar.length; i++) {
				if(ar[i] != null)
				{
				 if(k!=0)
					buffer.append(",");
				 buffer.append(ar[i]+"");
				 k++;
			}
			}
		}
		return buffer.toString();
		
	}
}
