# Current Backend Architecture
<img src="https://raw.githubusercontent.com/Hondohondo/hoa/master/backend/back-end_architecture.png" width="5000">

# Backend Universal Conventions

<h4>Horizontally Scalable</h4>
<p>The backend is designed to be horizontally scalable. As such, the backend file-structure system must be coordinated in order to maintain its integrity. Each new feature folder must have the following folders (Note this is something a Dev-Ops team would automate):</p>
  <ul>
    <li>
      /NAME/_application
      <ul>
        <li>/NAME/_handlers</li>
        <li>/NAME/_agents</li>
      </ul>
    </li>
    <li>
      /NAME/_domain
      <ul>
        <li>/NAME/_service_cluster</li>
        <li>/NAME/DB_Direct-Access_Service-Proxy</li>
        <li>/NAME/DB</li>
      </ul>
    </li>
  </ul>
</br>
<h4>delete_me.txt</h4>
<p>One interesting feature of Git and Github is that empty directories are forbidden. This means if there is an instance where a file is nested within a part-whole hierarchy, a "shortcut" is automatically presented leading to the next folder with a file in it. To prevent this and allow logical file path navigation, delete_me.txt folders have been created in directories which would otherwise be empty. Feel free to delete these files once the folder has been populated.</p>

